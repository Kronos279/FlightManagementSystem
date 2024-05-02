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
	private int flight_id;
	private String pnrNumber;
	transient FlightDetails flightetails;

}
