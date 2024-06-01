package com.FMS.serviceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.Exception.ResourceNotFoundException;
import com.FMS.entity.FlightDetails;
import com.FMS.repository.SearchFlightDetails;
import com.FMS.service.SearchService;

@Service
public class FlightServiceImpl implements SearchService{
	private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);
	@Autowired
	SearchFlightDetails repo;

	@Override
	public List<FlightDetails> getAll() {
		logger.info("Getting List of all Flight Detials");
		return repo.findAll();
	}
	
	@Override
	public List<FlightDetails> findFlights(String source, String destination, LocalDate date) {
		List<FlightDetails> list = repo.findBySourceAndDestinationAndDate(source, destination, date);
		logger.info("Retrived flights from "+source+" to "+destination+" on "+date);
		if(list.isEmpty()) {
			logger.error("No Flights availabe for this date "+date);
			throw new ResourceNotFoundException("No Flights Available for this date "+ date);
		}
		else {
        return list;
		}
    }

	
}
