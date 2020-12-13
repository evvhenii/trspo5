package com.example.demo.api.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.CashRegisterService;
import com.example.demo.service.model.CashRegister;


@RestController
@RequestMapping(value = "/cashregisters")
public class CashRegisterController {
	private final CashRegisterService cashRegisterService;
	
	@Autowired 
    public CashRegisterController(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }
	
	@PostMapping
    public ResponseEntity<CashRegister> create(@RequestParam String name, @RequestParam int amountOfCash) {
        return ResponseEntity.ok(cashRegisterService.createCashRegister(name, amountOfCash));
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        return ResponseEntity.ok(cashRegisterService.cashRegistersReport());
    }
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam String id) {
		cashRegisterService.deleteCashRegisterById(id);
        return ResponseEntity.noContent().build();
    }
	
	@PutMapping
	public void update(@RequestParam String cashRegisterId, @RequestParam int price){
		cashRegisterService.addCash(cashRegisterId, price);
	}
	
}
