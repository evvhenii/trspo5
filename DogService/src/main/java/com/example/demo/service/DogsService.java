package com.example.demo.service;

import java.util.List;

import com.example.demo.service.model.Breed;
import com.example.demo.service.model.Dog;

public interface DogsService {
		
	void sellDogFromStore(String id);
	
	int getDogPrice(String id);
	
	Dog takeInStore(Breed breed, String name, String description, int price);	
	
	String dogsReport();
	
	Dog getDogById(String id);

	List<Dog> getDogs();

	void createDog(Dog dog);
}
