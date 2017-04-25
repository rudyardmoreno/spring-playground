package com.example;

import com.example.model.data.entities.Employee;
import com.example.model.data.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Profile("default")
	public CommandLineRunner seedData(EmployeeRepository employeeRepository) {
		return (args) -> {
			employeeRepository.deleteAll();

			Employee employee = new Employee();
			employee.setId((long) 0);
			employee.setName("Employee 1");
			employee.setSalary(24);
			employeeRepository.save(employee);

			employee.setId((long) 0);
			employee.setName("Employee 2");
			employee.setSalary(22);
			employeeRepository.save(employee);

			employee.setId((long)0);
			employee.setName("Employee 3");
			employee.setSalary(20);
			employeeRepository.save(employee);

			employee.setId((long)0);
			employee.setName("Employee 4");
			employee.setSalary(18);
			employeeRepository.save(employee);
		};
	}
}