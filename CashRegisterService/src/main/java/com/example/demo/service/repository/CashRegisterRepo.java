package com.example.demo.service.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.service.model.CashRegister;

public interface CashRegisterRepo extends CrudRepository<CashRegister, String>{

}
