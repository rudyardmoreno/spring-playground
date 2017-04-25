package com.example.model.data.repositories;

import com.example.model.data.entities.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 8 - Spring Security
 * Model - EmployeeRepository
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


}