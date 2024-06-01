package com.FMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FMS.Model.EmailStructure;
import com.FMS.service.MailServiceImpl;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	MailServiceImpl service;
	
	@PostMapping("/send/{email}")
	public String sendMail(@PathVariable("email") String email, @RequestBody EmailStructure structure ) {
		service.sendMail(email, structure);
		
		return "Mail Sent";
		
	}
}
