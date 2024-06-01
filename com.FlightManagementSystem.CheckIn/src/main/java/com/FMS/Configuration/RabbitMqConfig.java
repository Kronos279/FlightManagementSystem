package com.FMS.Configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMqConfig {

	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.queue.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.queue.routingkey}")
	private String routingKey;
	
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	
	//Binding The Queue and Exchange
	@Bean
	public Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(exchange())
				.with(routingKey);
	}
}
