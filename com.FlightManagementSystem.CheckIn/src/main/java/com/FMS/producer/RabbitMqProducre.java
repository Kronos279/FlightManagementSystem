package com.FMS.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProducre {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMqProducre.class);
	
	@Value("${rabbitmq.queue.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.queue.routingkey}")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate template;
	
	public void sendMessage(String message) {
		logger.info("Message Sent -> %s",message);
		template.convertAndSend(exchange,routingKey,message);
	}
	
	
}
