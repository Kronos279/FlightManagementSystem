package com.FMS.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {
	
	private String OrderId;
	private String currency;
	private int amount;
	private String key_id;
}
