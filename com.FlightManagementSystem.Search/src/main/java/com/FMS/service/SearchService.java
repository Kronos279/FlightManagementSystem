package com.FMS.service;

import java.sql.Date;
import java.util.List;

import com.FMS.entity.FlightDetails;


public interface SearchService {

//	public FlightDetails getFlightDetailsByParameters();
	public List<FlightDetails> getAll();
	public List<FlightDetails> findFlights(String source, String destination, Date date);
}
