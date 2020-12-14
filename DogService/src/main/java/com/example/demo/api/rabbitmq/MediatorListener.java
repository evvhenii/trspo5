package com.example.demo.api.rabbitmq;

import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.SellDogRequest;
import com.example.demo.service.DogsService;
import com.example.demo.service.model.Dog;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class MediatorListener {
	private final static String ADDING = "dog_adding";
	private final static String DELETING = "dog_deleting";
	private final DogsService dogsService;
	private final CashRegisterSender cashRegisterSender;

	@Autowired
	public MediatorListener(DogsService dogsService, CashRegisterSender cashRegisterSender) {
		this.dogsService = dogsService;
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
			Dog dog = new ObjectMapper().readValue(message, Dog.class);

			System.out.println(" [x] Received message to create '" + dog + "'");
			dogsService.createDog(dog);
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
			SellDogRequest sellDogRequest = new ObjectMapper()
					                          .readValue(message, SellDogRequest.class);
			
			
			int dogPrice = dogsService.getDogPrice(sellDogRequest.getDogId());
			dogsService.sellDogFromStore(sellDogRequest.getDogId());
			
			try {
				cashRegisterSender.updateCashRegisterBalance(sellDogRequest.getCashRegisterId(), dogPrice);
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
			
			System.out.println(" [x] Received message to sell dog with id '" 
			                    + sellDogRequest.getDogId() + "'");
		};
		channel.basicConsume(DELETING, true, deliverCallback, consumerTag -> {});
	}
}

