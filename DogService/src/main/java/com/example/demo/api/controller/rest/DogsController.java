package com.example.demo.api.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.service.DogsService;
import com.example.demo.service.model.Breed;
import com.example.demo.service.model.Dog;


@RestController
@RequestMapping(value = "dogs")
public class DogsController {
	private final DogsService dogsService;
	
	@Autowired 
    public DogsController(DogsService dogsService) {
      this.dogsService = dogsService;
    }
	
	@PostMapping
    public ResponseEntity<Dog> create(@RequestParam Breed breed, @RequestParam String name, 
    		                          @RequestParam String description, @RequestParam int price) {
		
        return ResponseEntity.ok(dogsService.takeInStore(breed, name, description, price));
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        return ResponseEntity.ok(dogsService.dogsReport());
    }
	
	@DeleteMapping
	public void delete(@RequestParam String dogId, @RequestParam String cashRegisterId) {
		int dogPrice = dogsService.getDogPrice(dogId);
		dogsService.sellDogFromStore(dogId);
 
		String address = "http://cashregister-service:8083/cashregisters/";
        RestTemplate restTempl = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("cashRegisterId", cashRegisterId).
                queryParam("price", dogPrice);
        restTempl.exchange(builder.toUriString(), HttpMethod.PUT, null, String.class);
    }	
}
