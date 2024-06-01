package com.FMS.service;

import java.util.List;

import com.FMS.entity.FlightSeat;

public interface FlightSeatService {

	public String createFlightSeats(int flight_id);
	public int CountSeat(int id);
	public List<FlightSeat> getAllSeatsById(int id);
}
