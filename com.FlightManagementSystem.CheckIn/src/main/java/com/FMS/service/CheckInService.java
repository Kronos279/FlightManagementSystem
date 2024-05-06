package com.FMS.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FMS.entity.BookingInfo;
import com.FMS.entity.CheckIn;
import com.FMS.entity.FlightSeat;

@Service
public interface CheckInService {


	public CheckIn bookSeat(CheckIn checkin);
	public ResponseEntity<List<BookingInfo>> getBooking(String pnr);
	public List<FlightSeat> getAvailableSeats(int flight_id);
	public List<FlightSeat> getAllSeats();
	
}
