package com.example.demo.models.accessory;

import java.util.UUID;

import lombok.Data;

@Data
public final class Accessory{
	private String id;
	private Type type;
	private Color color;
	private int price;

	public Accessory() {}
	
	public Accessory(Type type, Color color, int price){
		this.id = UUID.randomUUID().toString();
		this.type = type;
		this.color = color;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

}
