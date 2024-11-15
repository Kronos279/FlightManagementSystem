package com.FMS.BookingInfoClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.FMS.entity.FlightDetails;

@FeignClient(name="com.FlightManagementSystem.FlightDetails")
public interface BookingInfoClient {

	@GetMapping("/flightdetails/{id}")
	public FlightDetails getFlightDetailById(@PathVariable("id") int id);
	


}
