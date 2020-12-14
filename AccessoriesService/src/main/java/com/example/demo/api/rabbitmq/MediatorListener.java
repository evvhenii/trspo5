package com.example.demo.api.rabbitmq;

import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.SellAccessoryRequest;
import com.example.demo.service.AccessoriesService;
import com.example.demo.service.model.Accessory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class MediatorListener {
	private final static String ADDING = "accessory_adding";
	private final static String DELETING = "accessory_deleting";
	private final AccessoriesService accessoriesService;
	private final CashRegisterSender cashRegisterSender;

	@Autowired
	public MediatorListener(AccessoriesService accessoriesService, CashRegisterSender cashRegisterSender) {
		this.accessoriesService = accessoriesService;
		this.cashRegisterSender = cashRegisterSender;
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
			Accessory accessory = new ObjectMapper().readValue(message, Accessory.class);

			System.out.println(" [x] Received message to create '" + accessory + "'");
			accessoriesService.createAccessory(accessory);
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
			String message = new String(delivery.getBody(), "UTF-8");
			SellAccessoryRequest sellAccessoryRequest = new ObjectMapper()
					                          .readValue(message, SellAccessoryRequest.class);
			
			int accessoryPrice = accessoriesService.getAccessoryPrice(sellAccessoryRequest.getAccessoryId());
			accessoriesService.sellAccessoryFromStore(sellAccessoryRequest.getAccessoryId());
			System.out.println(accessoryPrice);
			System.out.println(sellAccessoryRequest.getCashRegisterId());
			
			try {
				cashRegisterSender.updateCashRegisterBalance(sellAccessoryRequest.getCashRegisterId(), accessoryPrice);
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
	        
			System.out.println(" [x] Received message to sell accessory with id '" 
			                    + sellAccessoryRequest.getAccessoryId() + "'");
			
		};
		channel.basicConsume(DELETING, true, deliverCallback, consumerTag -> {});
	}
}

