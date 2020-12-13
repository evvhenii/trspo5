package com.example.demo.service.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.service.model.Accessory;


public interface AccessoriesRepo extends CrudRepository<Accessory, String> {

}

