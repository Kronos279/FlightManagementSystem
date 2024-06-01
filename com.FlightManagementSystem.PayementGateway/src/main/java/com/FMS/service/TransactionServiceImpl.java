package com.FMS.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.FMS.Entity.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class TransactionServiceImpl {

	private static final String Key ="rzp_test_UbAdHr8eO5gU5e";
	private static final String SecretKey="OPeq2jbaQp0b0vk2Ku4zgyLO";
	private static final String currency ="INR";
	
	
	public TransactionDetails createTransaction(double amount) {
		System.out.println(Key);
		System.out.println(SecretKey);
		
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount*100));
			jsonObject.put("currency", currency);
			RazorpayClient client = new RazorpayClient(Key,SecretKey);
			Order order = client.orders.create(jsonObject);
			System.out.println(order);
			return createTransaction(order);
		} catch (RazorpayException e) {
			e.printStackTrace();
			return null;
		}
			
	}
	
	public TransactionDetails createTransaction(Order order) {
		String order_id =  order.get("id");
		int amount = order.get("amount");
		String currency = order.get("currency");
		TransactionDetails transaction = new TransactionDetails(order_id, currency, amount,Key);
		
		return transaction;
	}
}

