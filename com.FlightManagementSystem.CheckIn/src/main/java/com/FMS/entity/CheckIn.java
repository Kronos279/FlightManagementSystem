package com.FMS.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckIn {
	
	private String booking_id;
	private int flight_id;
	private int seat_id;

	transient List<BookingInfo> booingInfo;
}
