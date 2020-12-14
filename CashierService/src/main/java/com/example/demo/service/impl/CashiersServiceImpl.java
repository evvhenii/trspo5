package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.CashierService;
import com.example.demo.service.model.Cashier;
import com.example.demo.service.repository.CashierRepo;

@Service
public class CashiersServiceImpl implements CashierService {
	
	private final CashierRepo cashierRepo;
	
	@Autowired
	CashiersServiceImpl(CashierRepo cashierRepo){
		this.cashierRepo = cashierRepo;
	}
	
	
	@Override
	public Cashier createCashier(String name) {
		Cashier cashier = new Cashier(name);
		cashierRepo.save(cashier);
		return cashier;
	}
	
	@Override
	public List<Cashier> getCashiers() {  
		List<Cashier> cashiers=(List<Cashier>)cashierRepo.findAll();
		return cashiers;
	}
	
	@Override
	public void createCashier(Cashier cashier) {
		cashierRepo.save(cashier);
	}
	
	@Override
	public String cashiersReport() {  
		List<Cashier> cashiers=(List<Cashier>)cashierRepo.findAll();
		
        System.out.println("CASHIERS:");
        String report = "";
        
        for(Cashier cashier : cashiers) {
        	System.out.println(cashier);
            report += cashier + "\n";
        }

        return report;
    }
	
	@Override
	public void deleteCashierById(String id) {
		cashierRepo.delete(getCashierById(id));
	}
	
	@Override
	public Cashier getCashierById(String id) {
        return cashierRepo.findById(id).get();
    }
}