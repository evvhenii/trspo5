package com.example.demo.api.rabbitmq;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SellDogRequest;
import com.example.demo.models.dog.Breed;
import com.example.demo.models.dog.Dog;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@RestController
@RequestMapping(value = "/rabbitmq_dogs")
public class DogSender {
	private final static String ADDING = "dog_adding";
	private final static String DELETING = "dog_deleting";
	
	@PostMapping
    public ResponseEntity<String> create(@RequestParam Breed breed, 
    		                             @RequestParam String name, 
                                         @RequestParam String description, 
                                         @RequestParam int price) throws Exception {	
		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(ADDING, true, false, false, null);
            Dog dog = new Dog(breed, name, description, price);
            channel.basicPublish("", ADDING, null, new ObjectMapper().writeValueAsBytes(dog));
            System.out.println(" [x] Sent 'create " + dog + "'");
        }
        return ResponseEntity.ok().build(); 
    }
	
	@DeleteMapping
    public ResponseEntity<String> delete(@RequestBody SellDogRequest sellDogRequest) throws Exception {		
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel(); 
            channel.queueDeclare(DELETING, true, false, false, null);
            channel.basicPublish("", DELETING, null, new ObjectMapper().writeValueAsBytes(sellDogRequest));
            System.out.println(" [x] Sent 'sell dog " + sellDogRequest);
        }
        return ResponseEntity.ok().build(); 
    }
}
