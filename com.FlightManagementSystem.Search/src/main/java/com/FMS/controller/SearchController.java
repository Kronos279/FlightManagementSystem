package com.FMS.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.entity.FlightDetails;
import com.FMS.serviceImpl.FlightServiceImpl;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	FlightServiceImpl service;
	
	 @GetMapping
	 public ResponseEntity<List<FlightDetails>>  findFlights(
	            @RequestParam String source,
	            @RequestParam String destination,
	            @RequestParam String date){
		 Date date1 = Date.valueOf(date);
		 List<FlightDetails> details =service.findFlights(source, destination, date1);
		 return new ResponseEntity<List<FlightDetails>>(details, HttpStatus.OK);
	 }

}
