package com.example.demo.api.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.service.AccessoriesService;
import com.example.demo.service.model.*;


@RestController
@RequestMapping(value = "accessories")
public class AccessoriesController {
	private final AccessoriesService accessoriesService;	
	
	@Autowired 
    public AccessoriesController(AccessoriesService accessoriesService) {
        this.accessoriesService = accessoriesService;
    }
	
	@PostMapping
    public ResponseEntity<Accessory> create(@RequestParam Type type, @RequestParam Color color, 
    		                          @RequestParam int price) {
        return ResponseEntity.ok(accessoriesService.takeInStore(type, color, price));
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        return ResponseEntity.ok(accessoriesService.AccessoriesReport());
    }
	
	@DeleteMapping
	public void delete(@RequestParam String accessoryId, @RequestParam String cashRegisterId) {
		int accessoryPrice = accessoriesService.getAccessoryPrice(accessoryId);
		accessoriesService.sellAccessoryFromStore(accessoryId);
		
		String address = "http://cashregister-service:8083/cashregisters/";
        RestTemplate restTempl = new RestTemplate();
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("cashRegisterId", cashRegisterId).
                queryParam("price", accessoryPrice);
        restTempl.exchange(builder.toUriString(), HttpMethod.PUT, null, String.class);
    }
}
