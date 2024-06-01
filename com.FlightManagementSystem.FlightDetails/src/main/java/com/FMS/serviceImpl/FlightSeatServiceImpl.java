package com.FMS.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.Exception.ResourceNotFoundException;
import com.FMS.entity.FlightSeat;
import com.FMS.repository.FlightSeatRepository;
import com.FMS.service.FlightSeatService;

@Service
public class FlightSeatServiceImpl implements FlightSeatService{
	private static final Logger logger = LoggerFactory.getLogger(FlightSeatServiceImpl.class);
	@Autowired
	FlightSeatRepository repo;

	@Override
	public String createFlightSeats(int flight_id) {
		logger.info("Populating Flight Seats for flight Id "+flight_id);
		for(int i=1;i<=30;i++) {
			FlightSeat seat;
				String num = String.valueOf(i);
				String a = num.concat("A");
				seat = new FlightSeat(a,flight_id);
				repo.save(seat);
				String b = num.concat("B");
				seat = new FlightSeat(b,flight_id);
				repo.save(seat);
				String c = num.concat("C");
				seat = new FlightSeat(c,flight_id);
				repo.save(seat);
				String d = num.concat("D");
				seat = new FlightSeat(d,flight_id);
				repo.save(seat);
				String e = num.concat("E");
				seat = new FlightSeat(e,flight_id);
				
				repo.save(seat);
				String f = num.concat("F");
				seat = new FlightSeat(f,flight_id);
				
				repo.save(seat);
				
			
		}
		return "Successfull";
	}
	
	@Override
	public int CountSeat(int id) {
		List<FlightSeat> allseats= repo.findByFlightId(id);
		int countSeats =allseats.size();
		return countSeats;
		
	}
	
	@Override
	public List<FlightSeat> getAllSeatsById(int id){
		List<FlightSeat> list = repo.findByFlightId(id);
		if(list.isEmpty()) {
			throw new ResourceNotFoundException("No Flights with id :"+id);
		}
		else {
		return list;
		}
	}
	
	

}
