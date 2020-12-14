package com.example.demo.service.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.Data;


@Entity
@EnableAutoConfiguration
@Data
public final class Accessory{
	
	@Id
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
	
	public String getType() {
		return type.toString();
	}
	
	public String getColor() {
		return color.toString();
	}
	
	public String getId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}

}
