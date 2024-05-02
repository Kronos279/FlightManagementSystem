package com.FMS.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDetails {

	private int flight_id;
	private String flight_number;
	private String source;
	private String destination;
	private Date date;
	private String departure_time;
	private double fare;
	
}
