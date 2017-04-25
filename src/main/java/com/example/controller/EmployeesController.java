package com.example.controller;

import com.example.model.data.entities.Employee;
import com.example.model.data.repositories.EmployeeRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rudyard Moreno on 4/18/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit
 */
@RestController

public class EmployeesController {
    private final EmployeeRepository repository;

    public EmployeesController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/admin/employees")
    public Iterable<Employee> all() {
        return this.repository.findAll();
    }

    @GetMapping("/employees")
    public String getEmployees() {
        return "Super secret list of employees";
    }

    @GetMapping("/me")
    public Employee getMe(@AuthenticationPrincipal Employee employee) {
        return employee;
    }
}

