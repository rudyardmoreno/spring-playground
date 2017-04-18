package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rudyard Moreno on 4/18/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit
 */
@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @GetMapping("")
    public String getEmployees() {
        return "Super secret list of employees";
    }
}

