package com.FMS.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.FMS.entity.FlightDetails;


public interface SearchService {

//	public FlightDetails getFlightDetailsByParameters();
	public List<FlightDetails> getAll();
	public List<FlightDetails> findFlights(String source, String destination, LocalDate date);
	}
