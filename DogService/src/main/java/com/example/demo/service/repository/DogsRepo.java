package com.example.demo.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.service.model.Dog;


@Repository
public interface DogsRepo extends CrudRepository<Dog, String> {

}
