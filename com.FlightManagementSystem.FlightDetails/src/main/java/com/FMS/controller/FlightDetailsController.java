package com.FMS.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.entity.FlightDetails;
import com.FMS.serviceImpl.FlightDetailsServiceImpl;

@RestController
@RequestMapping("/flightdetails")
public class FlightDetailsController {
	
	@Autowired
	private FlightDetailsServiceImpl service;
	
	@GetMapping("/{id}")
	public ResponseEntity<FlightDetails>  getFlightDetailById(@PathVariable("id") int id) {
		FlightDetails details = service.getFlightDetailsById(id);
		return new ResponseEntity<FlightDetails>(details, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<FlightDetails>> getFlightDetails(){
		List<FlightDetails> list = service.getAll();
		return new ResponseEntity<List<FlightDetails>>(list,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FlightDetails> addFlightDetails(@RequestBody FlightDetails flightdetails) {
		FlightDetails details = service.addFlightDetails(flightdetails);
		return new ResponseEntity<FlightDetails>(details, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFlightDetails(@PathVariable("id") int id) {
		service.deleteFlightDetails(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
