package com.example.demo.api.rabbitmq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SellAccessoryRequest;
import com.example.demo.models.accessory.Accessory;
import com.example.demo.models.accessory.Color;
import com.example.demo.models.accessory.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@RestController
@RequestMapping(value = "/rabbitmq_accessories")
public class AccessorySender {
	private final static String ADDING = "accessory_adding";
	private final static String DELETING = "accessory_deleting";
	
	@PostMapping
    public ResponseEntity<String> create(@RequestParam Type type, 
    		                             @RequestParam Color color, 
                                         @RequestParam int price) throws Exception {	
		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(ADDING, true, false, false, null);
            Accessory accessory = new Accessory(type, color, price);
            channel.basicPublish("", ADDING, null, new ObjectMapper().writeValueAsBytes(accessory));
            System.out.println(" [x] Sent create" + accessory);
        }
        return ResponseEntity.ok().build(); 
    }
	
	@DeleteMapping
    public ResponseEntity<String> delete(@RequestBody SellAccessoryRequest sellAccessoryRequest) throws Exception {		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(DELETING, true, false, false, null);
            channel.basicPublish("", DELETING, null, new ObjectMapper().writeValueAsBytes(sellAccessoryRequest));
            System.out.println(" [x] Sent 'sell accessory " + sellAccessoryRequest);
        }
        return ResponseEntity.ok().build(); 
    }
}
