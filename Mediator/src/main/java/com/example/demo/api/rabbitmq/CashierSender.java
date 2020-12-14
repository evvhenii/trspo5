package com.example.demo.api.rabbitmq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.example.demo.models.cashier.Cashier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

@RestController
@RequestMapping(value = "/rabbitmq_cashiers")
public class CashierSender {
	private final static String ADDING = "cashier_adding";
	private final static String DELETING = "cashier_deleting";

	@PostMapping
    public ResponseEntity<String> create(@RequestParam String name) throws Exception {		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //factory.setPort(10001);
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(ADDING, true, false, false, null);
            Cashier cashier = new Cashier(name);
            channel.basicPublish("", ADDING, null, new ObjectMapper().writeValueAsBytes(cashier));
            System.out.println(" [x] Sent " + cashier);
        }
        return ResponseEntity.ok().build(); 
    }
	
	@DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String id) throws Exception {		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //factory.setPort(10002);
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(DELETING, true, false, false, null);
            channel.basicPublish("", DELETING, null, id.getBytes());
            System.out.println(" [x] Sent 'delete cashier with id " + id);
        }
        return ResponseEntity.ok().build(); 
    }
}
