package com.FMS.entity;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flight_id;
	private String flight_number;
	private String source;
	private String destination;
	private LocalDate date;
	private String departure_time;
	private String arrival_time;
	private Double fare;
}
