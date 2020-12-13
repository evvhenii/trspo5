package com.example.demo.api.controllers.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/cashregisters")
public class CashRegisterController {
	private final RestTemplate template = new RestTemplate();
    private final String address = "http://localhost:8083/cashregisters/";
	
	@PostMapping
    public ResponseEntity<String> create(@RequestParam String name, @RequestParam int amountOfCash) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("amountOfCash", amountOfCash);
		
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
	public ResponseEntity<Object> delete(@RequestParam String id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id);
		
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }
	
	/*@PutMapping
	public ResponseEntity<String> update(@RequestParam String id, @RequestParam int price){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id).
                queryParam("price", price);
		
        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);
        return ResponseEntity.ok(response.getBody());
	}*/
	
}
