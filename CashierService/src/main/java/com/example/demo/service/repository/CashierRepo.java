package com.example.demo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.service.model.Cashier;


public interface CashierRepo extends JpaRepository<Cashier, String> {

}
