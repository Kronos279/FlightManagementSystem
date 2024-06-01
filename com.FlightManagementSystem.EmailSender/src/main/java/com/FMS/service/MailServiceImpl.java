package com.FMS.service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.FMS.Model.EmailStructure;

@Service
public class MailServiceImpl implements MailService{
	@Autowired
	private JavaMailSender mailsender;
	
	@Value("${spring.mail.username}")
	private String frommail;
	
	@Override
	@RabbitListener(queues="queue_email")
	public void sendMail(String mail, EmailStructure structure) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(frommail);
		simpleMailMessage.setSubject(structure.getSubject());
		simpleMailMessage.setText(structure.getMessage());
		simpleMailMessage.setTo(mail);
		
		mailsender.send(simpleMailMessage);
	}
}
