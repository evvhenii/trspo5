package com.example.demo.api.controllers.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.models.accessory.*;


@RestController
@RequestMapping(value = "accessories")
public class AccessoriesController {
	private final RestTemplate template = new RestTemplate();
    private final String address = "http://localhost:8081/accessories/";	
	
	@PostMapping
    public ResponseEntity<String> create(@RequestParam Type type, @RequestParam Color color, 
    		                          @RequestParam int price) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
	                queryParam("type", type).
	                queryParam("color", color).
	                queryParam("price", price);
		HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);
	    return ResponseEntity.ok(response.getBody());
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);
		
        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }
	
	@DeleteMapping
	public void delete(@RequestParam String cashRegisterId, @RequestParam String accessoryId) { 
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("accessoryId", accessoryId).
                queryParam("cashRegisterId", cashRegisterId);
        
        template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
    }
}
