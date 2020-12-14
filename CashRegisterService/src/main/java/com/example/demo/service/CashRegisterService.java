package com.example.demo.service;

import java.util.List;

import com.example.demo.service.model.CashRegister;

public interface CashRegisterService {
		
	String cashRegistersReport();
		
	void deleteCashRegisterById(String id);
	
	CashRegister getCashRegisterById(String id);
		
	void addCash(String id, int amountOfCash);
	
	CashRegister createCashRegister(String name, int amountOfCash);
		
	CashRegister getCashRegister(CashRegister cashReg);
	
	int getAmountOfCash(CashRegister cashReg);

	List<CashRegister> getCashRegisters();

	void createCashRegister(CashRegister cashRegister);

}
