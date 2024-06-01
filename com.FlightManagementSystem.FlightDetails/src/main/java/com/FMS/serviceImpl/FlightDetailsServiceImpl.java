package com.FMS.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.Exception.ResourceNotFoundException;
import com.FMS.entity.FlightDetails;
import com.FMS.repository.FlightDetailsRepository;
import com.FMS.service.FlightDetailsService;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(FlightDetailsServiceImpl.class);
	@Autowired 
	FlightDetailsRepository repo;
	
	@Autowired
	FlightSeatServiceImpl SeatService;

	@Override
	public List<FlightDetails> getAll() {
		List<FlightDetails> list = repo.findAll();
		logger.info("Getting all FlightDetails");
		if(list.isEmpty()) {
			logger.info("Something went wrong while fetching Flight Details.");
			throw new ResourceNotFoundException("Something went wrong while fetching Flight Details.");
		}
		
		return list;
	}

	@Override
	public FlightDetails getFlightDetailsById(int id){
		Optional<FlightDetails> fd = repo.findById(id);
		logger.info("Finding FlightDetails with Id "+id);
		if(fd.isPresent()) {
			FlightDetails flightdetails = fd.get();
			logger.info("Found Flight details "+flightdetails.toString());
			return flightdetails;
		}
		else {
			logger.info("No Flight Found with Id "+id);
			 throw new ResourceNotFoundException("No Flight found with the id "+id);
		}
	}

	@Override
	public FlightDetails addFlightDetails(FlightDetails flightdetails) {
		FlightDetails fd = repo.save(flightdetails);
		logger.info("Flight Details Added to the MySql Database");
		SeatService.createFlightSeats(fd.getFlight_id());
		logger.info("Populated Seats for Flight "+fd.getFlight_id());
		return fd;
	}

	@Override
	public FlightDetails deleteFlightDetails(int id) {
		repo.deleteById(id);
		logger.info("Deleted FlightDetail");
		return null;
	}

	@Override
	public FlightDetails updateFlightDetails(int id,FlightDetails updatedDetails) {
		Optional<FlightDetails> optionalFD = repo.findById(id);
		if(optionalFD.isPresent()) {
			FlightDetails oldFD = optionalFD.get();
			oldFD.setFlight_number(!updatedDetails.getFlight_number().isEmpty() ? updatedDetails.getFlight_number():oldFD.getFlight_number());
			oldFD.setSource(!updatedDetails.getSource().isEmpty() ? updatedDetails.getSource() : oldFD.getSource());
	        oldFD.setDestination(!updatedDetails.getDestination().isEmpty() ? updatedDetails.getDestination() : oldFD.getDestination());
	        oldFD.setDate(updatedDetails.getDate() != null ? updatedDetails.getDate() : oldFD.getDate());
	        oldFD.setDeparture_time(!updatedDetails.getDeparture_time().isEmpty() ? updatedDetails.getDeparture_time() : oldFD.getDeparture_time());
	        oldFD.setArrival_time(!updatedDetails.getArrival_time().isEmpty() ? updatedDetails.getArrival_time() : oldFD.getArrival_time());
	        oldFD.setFare(updatedDetails.getFare() != null ? updatedDetails.getFare() : oldFD.getFare());
            return repo.save(oldFD);
		}else {
			throw new ResourceNotFoundException("No flights found whith id "+id);
		}
		
	}
	
	
	
	
}
