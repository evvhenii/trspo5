package com.example.demo.service;

import java.util.List;

import com.example.demo.service.model.Cashier;

public interface CashierService {
	
	String cashiersReport();
		
	void deleteCashierById(String id);
	
	Cashier getCashierById(String id);
		
	Cashier createCashier(String name);

	List<Cashier> getCashiers();

	void createCashier(Cashier cashier);
}
