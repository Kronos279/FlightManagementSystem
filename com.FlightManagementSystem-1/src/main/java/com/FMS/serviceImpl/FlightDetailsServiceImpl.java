package com.FMS.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.entity.FlightDetails;
import com.FMS.repository.FlightDetailsRepository;
import com.FMS.service.FlightDetailsService;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired 
	FlightDetailsRepository repo;

	@Override
	public List<FlightDetails> getAll() {
		List<FlightDetails> list = repo.findAll();
		return list;
	}

	@Override
	public FlightDetails getFlightDetailsById(int id) {
		Optional<FlightDetails> fd = repo.findById(id);
		if(fd.isPresent()) {
			FlightDetails flightdetails = fd.get();
			return flightdetails;
		}
		else {
			return null;
		}
	}

	@Override
	public FlightDetails addFlightDetails(FlightDetails flightdetails) {
		return repo.save(flightdetails);
	}

	@Override
	public FlightDetails deleteFlightDetails(int id) {
		repo.deleteById(id);
		return null;
	}
	
	
	
	
}
