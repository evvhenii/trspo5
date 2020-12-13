package com.example.demo.api.controllers.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/cashiers")
public class CashierController {
	private final RestTemplate template = new RestTemplate();
    private final String address = "http://localhost:8082/cashiers";
	
	@PostMapping
    public ResponseEntity<String> create(@RequestParam String name) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name);
		HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);		
		return ResponseEntity.ok(response.getBody());
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        HttpEntity<String> answer = template.exchange(address, HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(answer.getBody());
    }
	
	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestParam String id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id);
        
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }
}
