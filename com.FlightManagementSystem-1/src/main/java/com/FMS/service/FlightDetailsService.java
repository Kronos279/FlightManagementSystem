package com.FMS.service;

import java.util.List;

import com.FMS.entity.FlightDetails;

public interface FlightDetailsService {
	
	public List<FlightDetails> getAll();
	public FlightDetails getFlightDetailsById(int id);
	public FlightDetails addFlightDetails(FlightDetails flightdetails);
	public FlightDetails deleteFlightDetails(int id);
	

}
