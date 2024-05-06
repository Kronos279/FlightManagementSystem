package com.FMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.entity.BookingInfo;
import com.FMS.entity.CheckIn;
import com.FMS.entity.FlightSeat;
import com.FMS.service.CheckInService;

@RestController
@RequestMapping("checkin")
public class CheckInController {

	@Autowired
	CheckInService service;
	
	@GetMapping
	public ResponseEntity<List<BookingInfo>> getBookingByPnr(@RequestParam("pnr") String pnr){
		return service.getBooking(pnr);
	}
	
	
	@PostMapping
	public ResponseEntity<CheckIn> bookSeat(@RequestBody CheckIn checkin){
		CheckIn result = service.bookSeat(checkin);
		if(result!= null) {
			return new ResponseEntity<>(result,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/seats")
	public List<FlightSeat> getAvailableSeats(@RequestParam("flight_id") int flight_id){
		return service.getAvailableSeats(flight_id);
	}
	
	@GetMapping("/allseats")
	public List<FlightSeat> getAllSeats(){
		return service.getAllSeats();
	}
	
	
}
