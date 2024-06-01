package com.FMS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInfo {
	
	
	private String booking_id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private long phoneNumber;
	private int flight_id;
	private String pnrNumber;
	private String seat_number;
	private int seat_id;
	
	transient FlightDetails flightdetails;

	
	
}
