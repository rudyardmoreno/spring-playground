package com.example.service;

import com.example.model.data.entities.Employee;
import com.example.model.data.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Rudyard Moreno on 4/25/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 8 - Spring Security
 */
@Service
public class EmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if (employee == null) throw new UsernameNotFoundException("Username " + username + " not found");
        return employee;
    }
}
