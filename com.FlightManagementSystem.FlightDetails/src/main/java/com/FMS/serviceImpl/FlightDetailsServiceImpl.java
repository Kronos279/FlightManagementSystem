package com.FMS.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.entity.FlightDetails;
import com.FMS.entity.FlightSeat;
import com.FMS.repository.FlightDetailsRepository;
import com.FMS.service.FlightDetailsService;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired 
	FlightDetailsRepository repo;
	
	@Autowired
	FlightSeatServiceImpl SeatService;

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
		FlightDetails fd = repo.save(flightdetails);
		System.out.println(fd.getFlight_id());
		SeatService.createFlightSeats(fd.getFlight_id());
		return fd;
	}

	@Override
	public FlightDetails deleteFlightDetails(int id) {
		repo.deleteById(id);
		return null;
	}
	
	
	
	
}
