package com.example.demo.service.model;

import java.util.UUID;
import javax.persistence.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.Data;


@EnableAutoConfiguration
@Entity
@Data
public final class Dog{
	@Id
	private String id;
	private Breed breed;
	private String name;
	private String description;
	private int price;
	
	public Dog() {}

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
	
	public String getBreed() {
		return breed.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPrice() {
		return price;
	}
	
	
}
