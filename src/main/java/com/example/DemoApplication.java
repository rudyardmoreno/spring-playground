package com.example;

import com.example.model.data.entities.Employee;
import com.example.model.data.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Profile("default")
	public CommandLineRunner seedData(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
		return (args) -> {
			employeeRepository.deleteAll();

			Employee employee = new Employee();
			employee.setId((long) 0);
			employee.setName("Employee 1");
			employee.setSalary(24);
			employee.setUsername("employee");
			employee.setPassword(passwordEncoder.encode("my-employee-password"));
			employee.setRole("EMPLOYEE");
			employeeRepository.save(employee);

			employee.setId((long) 0);
			employee.setName("Boss 1");
			employee.setSalary(22);
			employee.setUsername("boss");
			employee.setPassword(passwordEncoder.encode("my-boss-password"));
			employee.setRole("MANAGER");
			employeeRepository.save(employee);

			employee.setId((long)0);
			employee.setName("Admin 1");
			employee.setSalary(20);
			employee.setUsername("admin");
			employee.setPassword(passwordEncoder.encode("my-admin-password"));
			employee.setRole("ADMIN");
			employeeRepository.save(employee);

		};
	}
}