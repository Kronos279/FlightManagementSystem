package com.FMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FMS.BookingInfoClient.BookingInfoClient;
import com.FMS.Exception.ResourceNotFoundException;
import com.FMS.entity.BookingInfo;
import com.FMS.entity.CheckIn;
import com.FMS.entity.FlightSeat;
import com.FMS.repository.CheckInRepository;
import com.FMS.repository.FlightSeatRepository;
import com.FMS.service.CheckInService;
import com.netflix.discovery.converters.Auto;

@Service
public class CheckinServiceImpl implements CheckInService {

	@Autowired
	FlightSeatRepository repo;
	@Autowired
	CheckInRepository repo_check;
	@Autowired
	BookingInfoClient client;
	
	
	@Override
	public ResponseEntity<List<BookingInfo>> getBooking(String pnr){
		return client.getBookingInfoByPNR(pnr);
	}

	
	@Override
	public CheckIn bookSeat(CheckIn checkin) {
		repo.updateBookingIdById(checkin.getBooking_id(), checkin.getSeat_id());
		CheckIn newcheck = repo_check.save(checkin);
		BookingInfo info = client.getBooking(checkin.getBooking_id()).getBody();
		Optional<CheckIn> seat = repo_check.findById(checkin.getBooking_id());
			CheckIn seat1 = seat.get();
			System.out.println(seat1.getBooingInfo());
			info.setSeat_id(seat1.getSeat_id());
			FlightSeat seatnumber = repo.findById(seat1.getSeat_id()).get();
			info.setSeat_number(seatnumber.getSeatNumber());
			client.UpdateBookingInfo(info);
		return newcheck;
	}

	@Override
	public List<FlightSeat> getAvailableSeats(int flight_id) {
		List<FlightSeat> list = repo.findByFlightId(flight_id);
		List<FlightSeat> availableSeats = new ArrayList<>();
		for(FlightSeat seat : list) {
			if(seat.getBooking_id() == null) {
				availableSeats.add(seat);
			}
		}
		if(availableSeats.isEmpty()) {
			throw new ResourceNotFoundException("No Seats Available");
		}else {
		return availableSeats;
		}
	}
	
	@Override
	public List<FlightSeat> getAllSeats(){
		return repo.findAll();
	}
	
	


}
