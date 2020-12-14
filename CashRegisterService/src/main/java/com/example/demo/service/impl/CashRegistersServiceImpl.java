package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.CashRegisterService;
import com.example.demo.service.model.CashRegister;
import com.example.demo.service.repository.CashRegisterRepo;


@Service
public class CashRegistersServiceImpl implements CashRegisterService {
	
	private final CashRegisterRepo cashRegisterRepo;
	
	@Autowired
	CashRegistersServiceImpl(CashRegisterRepo cashRegisterRepo){
		this.cashRegisterRepo = cashRegisterRepo;
	}
	
	@Override
	public CashRegister createCashRegister(String name, int amountOfCash) {
		CashRegister cashRegister = new CashRegister(name, amountOfCash);
		cashRegisterRepo.save(cashRegister);
		return cashRegister;
	}
	
	@Override
	public void createCashRegister(CashRegister cashRegister) {
		cashRegisterRepo.save(cashRegister);
	}; 

	
	@Override
	public String cashRegistersReport() {  
		List<CashRegister> cashRegisters=(List<CashRegister>)cashRegisterRepo.findAll();
		
        System.out.println("CASH_REGISTERS:");
        String report = "";
        
        for(CashRegister cashRegister : cashRegisters) {
        	System.out.println(cashRegister);
            report += cashRegister + "\n";
        }

        return report;
    }
	
	@Override
	public List<CashRegister> getCashRegisters() {  
		List<CashRegister> cashRegisters=(List<CashRegister>)cashRegisterRepo.findAll();
		return cashRegisters;
	}
	
	
	
	
	@Override
	public void deleteCashRegisterById(String id) {
		cashRegisterRepo.delete(getCashRegisterById(id));
	}
	
	@Override
	public CashRegister getCashRegisterById(String id) {
        return cashRegisterRepo.findById(id).get();
    }
	
	@Override
	public CashRegister getCashRegister(CashRegister cashReg) {
		return cashReg;
	}
	
	@Override
	public int getAmountOfCash(CashRegister cashReg) {
		return cashReg.getAmountOfCash();
	}
	
	@Override 
	public void addCash(String id, int amountOfCash) {
		CashRegister cashRegister = cashRegisterRepo.findById(id).get();
		cashRegister.setAmountOfCash(amountOfCash + cashRegister.getAmountOfCash());
		cashRegisterRepo.save(cashRegister);
	}
}