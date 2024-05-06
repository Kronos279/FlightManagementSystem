package com.FMS.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Total Fare by PNR")
public class TotalFarePNR {
	
	@Id
	private String pnr;
	private double totalFare;
	
}
