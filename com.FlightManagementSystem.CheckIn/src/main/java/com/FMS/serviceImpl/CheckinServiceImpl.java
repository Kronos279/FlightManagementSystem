package com.FMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FMS.BookingInfoClient.BookingInfoClient;
import com.FMS.entity.BookingInfo;
import com.FMS.entity.CheckIn;
import com.FMS.entity.FlightSeat;
import com.FMS.repository.FlightSeatRepository;
import com.FMS.service.CheckInService;

@Service
public class CheckinServiceImpl implements CheckInService {

	@Autowired
	FlightSeatRepository repo;
	@Autowired
	BookingInfoClient client;
	
	@Override
	public List<FlightSeat> getAvailableSeats(CheckIn checkin) {
		
		List<FlightSeat> allseats = repo.findByFlightId(checkin.getFlight_id());
		List<FlightSeat> availableSeats = new ArrayList<>();
		for(FlightSeat seat : allseats) {
			if(seat.getBooking_id() == null) {
				availableSeats.add(seat);
			}
		}
		return availableSeats;
	}
	
	@Override
	public ResponseEntity<List<BookingInfo>> getBooking(String pnr){
		return client.getBookingInfoByPNR(pnr);
	}

	
	@Override
	public String bookSeat(CheckIn checkin) {
		repo.updateBookingIdById(checkin.getBooking_id(), checkin.getSeat_id());
		return "Successful";
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
		return availableSeats;
	}
	
	@Override
	public List<FlightSeat> getAllSeats(){
		return repo.findAll();
	}
	
	


}
