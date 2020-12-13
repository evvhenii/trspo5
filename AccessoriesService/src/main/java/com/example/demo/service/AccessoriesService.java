package com.example.demo.service;

import java.util.List;

import com.example.demo.service.model.*;

public interface AccessoriesService {
	
	void sellAccessoryFromStore(String id);
	
	int getAccessoryPrice(String id);
	
	Accessory takeInStore(Type type, Color color, int price);
	
	String AccessoriesReport();
	
	Accessory getAccessoryById(String id);

	List<Accessory> getAccessories();
}
