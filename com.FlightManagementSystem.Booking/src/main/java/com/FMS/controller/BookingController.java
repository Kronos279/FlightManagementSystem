package com.FMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.BookingInfoClient.BookingInfoClient;
import com.FMS.entity.BookingInfo;
import com.FMS.entity.FlightDetails;
import com.FMS.service.BookingInfoService;
import com.FMS.serviceImpl.BookingInfoServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingInfoService service;
	
	@PostMapping
	public ResponseEntity<List<BookingInfo>>  createBooking(@RequestBody List<BookingInfo> request){
		List<BookingInfo> list=service.addBooking(request);
		return new ResponseEntity<List<BookingInfo>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookingInfo> getBooking(@PathVariable("id") String id) {
		BookingInfo booking= service.getBookingInfoById(id);
		return new ResponseEntity<BookingInfo>(booking, HttpStatus.OK);
	}
	
	@GetMapping("/pnr/{pnr}")
	public ResponseEntity<List<BookingInfo>>  getBookingInfoByPNR(@PathVariable("pnr") String pnr) {
		List<BookingInfo> list = service.getBookingByPnr(pnr);
		return new ResponseEntity<List<BookingInfo>>(list,HttpStatus.OK);
		
		
	}
	
	
}
