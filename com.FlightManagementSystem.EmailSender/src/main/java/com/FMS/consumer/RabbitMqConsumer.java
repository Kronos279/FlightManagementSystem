package com.FMS.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.Model.EmailStructure;
import com.FMS.service.MailService;


@Service
public class RabbitMqConsumer {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMqConsumer.class);
	
	@Autowired
	MailService emailService;
	
	@RabbitListener(queues="queue_email")
	public void consume(String message) {
		EmailStructure structure = new EmailStructure("Web Checkin Done","Dear User you have successfully completed your WebCheckin");
		emailService.sendMail(message, structure);
		logger.info("Recieved email -> %s" + message);
	}
}
