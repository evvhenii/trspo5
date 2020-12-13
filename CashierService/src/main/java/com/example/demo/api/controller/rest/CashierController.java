package com.example.demo.api.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.CashierService;
import com.example.demo.service.model.Cashier;


@RestController
@RequestMapping(value = "/cashiers")
public class CashierController {
	private final CashierService cashRegisterService;
	
	@Autowired 
    public CashierController(CashierService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }
	
	@PostMapping
    public ResponseEntity<Cashier> create(@RequestParam String name) {
        return ResponseEntity.ok(cashRegisterService.createCashier(name));
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        return ResponseEntity.ok(cashRegisterService.cashiersReport());
    }
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam String id) {
		cashRegisterService.deleteCashierById(id);
        return ResponseEntity.noContent().build();
    }
}
