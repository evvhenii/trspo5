package com.example.demo.api.rabbitmq;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UpdateBalanceRequest;
import com.example.demo.service.CashRegisterService;
import com.example.demo.service.model.CashRegister;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class MediatorListener {
	private final static String ADDING = "cashregister_adding";
	private final static String DELETING = "cashregister_deleting";
	private final static String UPDATING = "cashregister_updating";

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

		channel.queueDeclare(ADDING, true, false, false, null);
		System.out.println(" [*] Waiting for messages...");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			CashRegister cashRegister = new ObjectMapper().readValue(message, CashRegister.class);

			System.out.println(" [x] Received message to create '" + cashRegister + "'");
			cashRegisterService.createCashRegister(cashRegister);
		};
		channel.basicConsume(ADDING, true, deliverCallback, consumerTag -> {});
	}
	
	@PostConstruct
	public void consumeDeleteMessageFromQueue() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();

		channel.queueDeclare(DELETING, true, false, false, null);
		System.out.println(" [*] Waiting for messages...");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String id = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received message to delete cashregister with id '" + id + "'");
			cashRegisterService.deleteCashRegisterById(id);
		};
		channel.basicConsume(DELETING, true, deliverCallback, consumerTag -> {});
	}
	
	
	@PostConstruct
	public void consumeUpdateMessageFromQueue() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();

		channel.queueDeclare(UPDATING, true, false, false, null);
		System.out.println(" [*] Waiting for messages...");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			UpdateBalanceRequest updateBalanceRequest = new ObjectMapper().readValue(message, UpdateBalanceRequest.class);
			System.out.println(" [x] Received message to '" + updateBalanceRequest + "'");
			cashRegisterService.addCash(updateBalanceRequest.getCashRegisterId(), updateBalanceRequest.getPrice());
		};
		channel.basicConsume(UPDATING, true, deliverCallback, consumerTag -> {});
	}
	
	
	
}

