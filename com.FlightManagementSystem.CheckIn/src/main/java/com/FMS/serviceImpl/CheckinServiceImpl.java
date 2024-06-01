package com.FMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FMS.BookingInfoClient.BookingInfoClient;
import com.FMS.Exception.ResourceNotFoundException;
import com.FMS.entity.BookingInfo;
import com.FMS.entity.CheckIn;
import com.FMS.entity.FlightSeat;
import com.FMS.producer.RabbitMqProducre;
import com.FMS.repository.CheckInRepository;
import com.FMS.repository.FlightSeatRepository;
import com.FMS.service.CheckInService;

@Service
public class CheckinServiceImpl implements CheckInService {

	private static final Logger logger = LoggerFactory.getLogger(CheckinServiceImpl.class);
	
	@Autowired
	FlightSeatRepository repo;
	@Autowired
	CheckInRepository repo_check;
	@Autowired
	BookingInfoClient client;
	
	@Autowired
	RabbitMqProducre producer;
	
	
	@Override
	public ResponseEntity<List<BookingInfo>> getBooking(String pnr){
		return client.getBookingInfoByPNR(pnr);
	}

	
	@Override
	public CheckIn bookSeat(CheckIn checkin) {
		if(checkin.getBooingInfo()!=null) {
			throw new RuntimeException("CheckinAlready Done");
		}
		else {
		logger.info("Initialing CheckIn");
		repo.updateBookingIdById(checkin.getBooking_id(), checkin.getSeat_id());
		CheckIn newcheck = repo_check.save(checkin);
		logger.info("User CheckIn Complete");
		BookingInfo info = client.getBooking(checkin.getBooking_id()).getBody();
		String email = info.getEmail();
		Optional<CheckIn> seat = repo_check.findById(checkin.getBooking_id());
			CheckIn seat1 = seat.get();
			info.setSeat_id(seat1.getSeat_id());
			FlightSeat seatnumber = repo.findById(seat1.getSeat_id()).get();
			info.setSeat_number(seatnumber.getSeatNumber());
			logger.info("Updating BookingInfo");
			client.UpdateBookingInfo(info);
			newcheck.setBooingInfo(info);
			producer.sendMessage(email);
			logger.info("Sent Email to RabbitMQ exchange");
			
		return newcheck;
		}
	}

	@Override
	public List<FlightSeat> getAvailableSeats(int flight_id) {
		logger.info("Getting Available Seats for FlightId "+ flight_id);
		List<FlightSeat> list = repo.findByFlightId(flight_id);
		List<FlightSeat> availableSeats = new ArrayList<>();
		logger.info("Update Available Seats List");
		for(FlightSeat seat : list) {
			if(seat.getBooking_id() == null) {
				availableSeats.add(seat);
			}
		}
		if(availableSeats.isEmpty()){
			logger.info("No Seats Available");
			throw new ResourceNotFoundException("No Seats Available");
		}else {
		return availableSeats;
		}
	}
	
	@Override
	public List<FlightSeat> getAllSeats(int flight_id){
		logger.error("Getting all Seats");
		List<FlightSeat> list = repo.findByFlightId(flight_id);
		return list;
	}
	
	
}
