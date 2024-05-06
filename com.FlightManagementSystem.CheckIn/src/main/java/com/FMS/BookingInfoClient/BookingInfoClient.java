package com.FMS.BookingInfoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.FMS.entity.BookingInfo;

@FeignClient(name="com.FlightManagementSystem.Booking")
public interface BookingInfoClient {

	@GetMapping("booking/pnr/{pnr}")
	public ResponseEntity<List<BookingInfo>>  getBookingInfoByPNR(@PathVariable("pnr") String pnr);
	
	@GetMapping("booking/{id}")
	public ResponseEntity<BookingInfo> getBooking(@PathVariable("id") String id);
	
	@PutMapping("/booking")
	public BookingInfo UpdateBookingInfo(BookingInfo bookingInfo);
}
