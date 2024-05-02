package com.FMS.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FMS.entity.FlightDetails;
import com.FMS.repository.SearchFlightDetails;
import com.FMS.service.SearchService;

@Service
public class FlightServiceImpl implements SearchService{
	
	@Autowired
	SearchFlightDetails repo;

	@Override
	public List<FlightDetails> getAll() {
		
		return repo.findAll();
	}
	
	@Override
	public List<FlightDetails> findFlights(String source, String destination, Date date) {
        return repo.findBySourceAndDestinationAndDate(source, destination, date);
    }

	
}