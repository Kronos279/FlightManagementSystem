package com.FMS.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.entity.FlightSeat;
import com.FMS.repository.FlightSeatRepository;
import com.FMS.service.FlightSeatService;

@Service
public class FlightSeatServiceImpl implements FlightSeatService{
	
	@Autowired
	FlightSeatRepository repo;

	@Override
	public String createFlightSeats(int flight_id) {
		
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

	
	
	

}