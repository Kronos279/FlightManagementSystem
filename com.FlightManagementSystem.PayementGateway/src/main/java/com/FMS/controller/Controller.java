package com.FMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.Entity.TransactionDetails;
import com.FMS.service.TransactionServiceImpl;
import com.razorpay.Order;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class Controller {

	@Autowired
	TransactionServiceImpl service;
	
	@GetMapping("/createTransaction")
	public ResponseEntity<?> createTransaction(@RequestParam("amount") double amount){
		TransactionDetails transaction = service.createTransaction(amount);
		return new ResponseEntity<TransactionDetails>( transaction, HttpStatus.OK);
	}
}
