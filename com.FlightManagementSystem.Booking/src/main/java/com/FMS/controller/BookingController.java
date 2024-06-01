package com.FMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.entity.BookingInfo;
import com.FMS.service.BookingInfoService;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	BookingInfoService service;
	
	@PostMapping
	public ResponseEntity<List<BookingInfo>> createBooking(@RequestBody List<BookingInfo> request){
		logger.info("Creating New Booking");
		List<BookingInfo> list=service.addBooking(request);
		return new ResponseEntity<List<BookingInfo>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookingInfo> getBooking(@PathVariable("id") String id) {
		logger.info("Getting Booking info");
		BookingInfo booking= service.getBookingInfoById(id);
		logger.info("Booking info "+booking.toString());
		return new ResponseEntity<BookingInfo>(booking, HttpStatus.OK);
	}
	
	@GetMapping("/pnr/{pnr}")
	public ResponseEntity<List<BookingInfo>> getBookingInfoByPNR(@PathVariable("pnr") String pnr) {
		logger.info("Getting Booking info by PNR");
		List<BookingInfo> list = service.getBookingByPnr(pnr);
		logger.info("Returned booking List");
		return new ResponseEntity<List<BookingInfo>>(list,HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<BookingInfo> UpdateBookingInfo(@RequestBody BookingInfo bookingInfo) {
		logger.info("Updating Booking Info");
		BookingInfo booking = service.updateBookingInfo(bookingInfo);
		return new ResponseEntity<BookingInfo> (booking,HttpStatus.OK);
	}
	
	@GetMapping("/bookingcount")
	public ResponseEntity<?> getCountOfBookings(@RequestParam("id") int id){
		int count = service.getBookingCountByFlightId(id);
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
		
	}
}
