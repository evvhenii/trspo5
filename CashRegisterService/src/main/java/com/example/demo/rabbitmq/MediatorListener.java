package com.example.demo.rabbitmq;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.CashRegisterService;
import com.example.demo.service.model.CashRegister;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class MediatorListener {
	private final static String ADDING = "cashregister_adding";
	private final static String DELETING = "cashregister_deleting";
	private final CashRegisterService cashRegisterService;

	@Autowired
	public MediatorListener(CashRegisterService cashRegisterService) {
		this.cashRegisterService = cashRegisterService;
	}
	
	@PostConstruct
	public void consumeCreateMessageFromQueue() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(ADDING, false, false, false, null);
		System.out.println(" [*] Waiting for messages...");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			CashRegister cashRegister = new ObjectMapper().readValue(message, CashRegister.class);

			System.out.println(" [x] Received message to create '" + cashRegister + "'");
			//cashRegisterService.createCashRegister(cashRegister);
		};
		channel.basicConsume(ADDING, true, deliverCallback, consumerTag -> {});
	}
	
	@PostConstruct
	public void consumeDeleteMessageFromQueue() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();

		channel.queueDeclare(DELETING, false, false, false, null);
		System.out.println(" [*] Waiting for messages...");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String id = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received message to delete cashregister with id '" + id + "'");
			//cashRegisterService.deleteCashRegisterById(id);
		};
		channel.basicConsume(DELETING, true, deliverCallback, consumerTag -> {});
	}
	
	
	//Creating consumer with @RabbitListener
	/*
	@RabbitListener(queues = ADDING) 
	public void consumeMessageFromQueue(String message) throws JsonMappingException, JsonProcessingException { 
		System.out.println(message);
		CashRegister cashRegister = new ObjectMapper().readValue(message, CashRegister.class);
		System.out.println(" [x] Received '" + cashRegister + "'");
		//cashRegisterService.createCashRegister(cashRegister); 
	}
	
	@RabbitListener(queues = DELETING) 
	public void consumeDeleteMessageFromQueue(String message) throws JsonMappingException, JsonProcessingException { 
		String id = message;
		System.out.println(" [x] Received request ' delete cashregister with id " + id + "'");
		//cashRegisterService.deleteCashRegisterById(id);
	}
	*/
}

