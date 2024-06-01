package com.FMS.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.entity.FlightDetails;
import com.FMS.serviceImpl.FlightServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController {
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	FlightServiceImpl service;
	
	 @GetMapping
	 public ResponseEntity<List<FlightDetails>>  findFlights(
	            @RequestParam String source,
	            @RequestParam String destination,
	            @RequestParam String date) throws ParseException{
		 LocalDate localDate = LocalDate.parse(date);
		 logger.info("Finding Flights");
		 List<FlightDetails> details =service.findFlights(source, destination, localDate);
		 return new ResponseEntity<List<FlightDetails>>(details, HttpStatus.OK);
	 }

}
