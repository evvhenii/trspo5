package com.example.demo.api.rabbitmq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.cashregister.CashRegister;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@RestController
@RequestMapping(value = "/rabbitmq_cashregisters")
public class CashRegisterSender {
	private final static String ADDING = "cashregister_adding";
	private final static String DELETING = "cashregister_deleting";
	
	@PostMapping
    public ResponseEntity<String> create(@RequestParam String name, 
    		                             @RequestParam int amountOfCash) throws Exception {	
		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(ADDING, true, false, false, null);
            CashRegister cashRegister = new CashRegister(name, amountOfCash);
            System.out.println(cashRegister);
            channel.basicPublish("", ADDING, null, new ObjectMapper().writeValueAsBytes(cashRegister));
            System.out.println(" [x] Sent " + cashRegister);
        }
        return ResponseEntity.ok().build(); 
    }
	
	@DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String id) throws Exception {		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(DELETING, true, false, false, null);
            channel.basicPublish("", DELETING, null, id.getBytes());
            System.out.println(" [x] Sent 'delete cashregister with id " + id);
        }
        return ResponseEntity.ok().build(); 
    }
}
