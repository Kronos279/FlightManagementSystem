package com.FMS.entity;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="flight_details")
public class FlightDetails {
	@Id
	private int flight_id;
	private String flight_number;
	private String source;
	private String destination;
	private Date date;
	private String departure_time;
	private double fare;
}
