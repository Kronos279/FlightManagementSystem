package com.FMS.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public FlightDetails getFlightDetailById(@PathVariable("id") int id) {
		return service.getFlightDetailsById(id);
	}
	
	@GetMapping
	public List<FlightDetails> getFlightDetails(){
		return service.getAll();
	}
	
	@PostMapping
	public FlightDetails addFlightDetails(@RequestBody FlightDetails flightdetails) {
		return service.addFlightDetails(flightdetails);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteFlightDetails(@PathVariable("id") int id) {
		service.deleteFlightDetails(id);
		return "Successful";
	}
	
}
