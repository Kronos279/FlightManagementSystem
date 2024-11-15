package com.FMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSeat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seat_id;
	private String seatNumber;
	private int flight_id;
	private String Booking_id;
	public FlightSeat(String seatNumber, int flight_id) {
		super();
		this.seatNumber = seatNumber;
		this.flight_id = flight_id;
	}
	
	
	
}
