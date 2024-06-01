package com.FMS.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailStructure {

	private String subject;
	private String message;
}
