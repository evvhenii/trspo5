package com.example.demo.models.dog;

import java.util.UUID;

import lombok.Data;

@Data
public final class Dog{
	private String id;
	private Breed breed;
	private String name;
	private String description;
	private int price;
	
	public Dog(Breed breed, String name, String description, int price){
		this.id = UUID.randomUUID().toString();
		this.breed = breed;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getDogId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}
}
