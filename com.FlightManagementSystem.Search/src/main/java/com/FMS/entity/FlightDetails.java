package com.FMS.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="flight_details")
public class FlightDetails {
	@Id
	private int flight_id;
	private String flight_number;
	private String source;
	private String destination;
	private LocalDate date;
	private String departure_time;
	private String arrival_time;
	private double fare;
}
