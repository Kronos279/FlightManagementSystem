package com.FMS.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.entity.FlightDetails;
import com.FMS.entity.FlightSeat;
import com.FMS.service.FlightSeatService;
import com.FMS.serviceImpl.FlightDetailsServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/flightdetails")
public class FlightDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(FlightDetailsController.class);
	@Autowired
	private FlightDetailsServiceImpl service;
	
	@Autowired
	private FlightSeatService seatservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<FlightDetails>  getFlightDetailById(@PathVariable("id") int id) {
		logger.info("Getting FlightDetails By Id "+id);
		FlightDetails details = service.getFlightDetailsById(id);
		return new ResponseEntity<FlightDetails>(details, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<FlightDetails>> getFlightDetails(){
		logger.info("Getting All FlightDetails");
		List<FlightDetails> list = service.getAll();
		return new ResponseEntity<List<FlightDetails>>(list,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FlightDetails> addFlightDetails(@RequestBody FlightDetails flightdetails) {
		logger.info("Adding FlightDetails");
		FlightDetails details = service.addFlightDetails(flightdetails);
		return new ResponseEntity<FlightDetails>(details, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFlightDetails(@PathVariable("id") int id) {
		logger.info("Deleting FlightDetails By Id "+id);
		service.deleteFlightDetails(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public ResponseEntity<?> getSeatCount(@RequestParam("id") int id) {
		int count = seatservice.CountSeat(id);
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}
	
	@GetMapping("/allseats")
	public ResponseEntity<?> getAllSeats(@RequestParam("id") int id){
		List<FlightSeat> list = seatservice.getAllSeatsById(id);
		return new ResponseEntity<List<FlightSeat>>(list, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateFlightDetails(@RequestParam("id") int id, @RequestBody FlightDetails flight){
		FlightDetails ob = service.updateFlightDetails(id, flight);
		return new ResponseEntity<FlightDetails>(ob,HttpStatus.OK);
	}
	

}
