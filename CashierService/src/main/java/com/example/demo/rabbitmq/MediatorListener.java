package com.example.demo.rabbitmq;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.CashierService;
import com.example.demo.service.model.Cashier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class MediatorListener {
	private final static String ADDING = "cashier_adding";
	private final static String DELETING = "cashier_deleting";
	private final CashierService cashRegisterService;

	@Autowired
	public MediatorListener(CashierService cashRegisterService) {
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
			Cashier cashier = new ObjectMapper().readValue(message, Cashier.class);

			System.out.println(" [x] Received message to create'" + cashier + "'");
			//cashRegisterService.createCashier(cashier);
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
			System.out.println(" [x] Received message to delete cashier with id '" + id + "'");
			//cashRegisterService.deleteCashierById(id);
		};
		channel.basicConsume(DELETING, true, deliverCallback, consumerTag -> {});
	}
	
	
	//Creating consumer with @RabbitListener
	/*
	@RabbitListener(queues = ADDING) 
	public void consumeCreateMessageFromQueue(String message) throws JsonMappingException, JsonProcessingException { 
		Cashier	cashier = new ObjectMapper().readValue(message, Cashier.class);
		System.out.println(" [x] Received create '" + cashier + "'");
		//cashRegisterService.createCashier(cashier); 
	}
	
	@RabbitListener(queues = DELETING) 
	public void consumeDeleteMessageFromQueue(String message) throws JsonMappingException, JsonProcessingException { 
		String id = message;
		System.out.println(" [x] Received request ' delete cashier with id " + id + "'");
		//cashRegisterService.deleteCashierById(id);
	}
	*/

}
