package com.FMS.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckIn {
	
	@Id
	private String booking_id;
	private int flight_id;
	private int seat_id;

	transient List<BookingInfo> booingInfo;
}
