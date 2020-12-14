package com.example.demo.api.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UpdateBalanceRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Component
public class CashRegisterSender {
	
	private final static String UPDATING = "cashregister_updating";
	
	public void updateCashRegisterBalance(String cashRegisterId, int price) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(UPDATING, true, false, false, null);
            UpdateBalanceRequest updateBalanceRequest = new UpdateBalanceRequest(cashRegisterId, price);
            channel.basicPublish("", UPDATING, null, new ObjectMapper().writeValueAsBytes(updateBalanceRequest));
            System.out.println(" [x] Sent updating" + updateBalanceRequest);
        }
		
	}

}
