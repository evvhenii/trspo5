package com.example.demo.models.cashregister;

import java.util.UUID;

import lombok.Data;

@Data
public final class CashRegister {
	private String id;
	private String name;
	private int amountOfCash;
		
	public CashRegister(String name, int amountOfCash){
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.amountOfCash = amountOfCash;
	}

	public int getAmountOfCash() {
		return amountOfCash;
	}

	public void setAmountOfCash(int amount) {
		this.amountOfCash = amount;
		System.out.println("In the cash register \"" + name + "\" " + amount + "Hryvnia");
	}
}
