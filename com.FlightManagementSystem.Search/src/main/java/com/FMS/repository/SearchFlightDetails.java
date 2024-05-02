package com.FMS.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FMS.entity.FlightDetails;

public interface SearchFlightDetails extends JpaRepository<FlightDetails, Integer>{
	
	List<FlightDetails> findBySourceAndDestinationAndDate(String source, String destination, Date date);
	
}
