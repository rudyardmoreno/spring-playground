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
			employee.setUsername("employee1");
			employee.setPassword("my-employee-password");
			employee.setRole("EMPLOYEE");
			employeeRepository.save(employee);

			employee.setId((long) 0);
			employee.setName("Employee 2");
			employee.setSalary(22);
			employee.setUsername("employee2");
			employee.setPassword("my-employee-password");
			employee.setRole("EMPLOYEE");
			employeeRepository.save(employee);

			employee.setId((long)0);
			employee.setName("Employee 3");
			employee.setSalary(20);
			employee.setUsername("employee3");
			employee.setPassword("my-employee-password");
			employee.setRole("EMPLOYEE");
			employeeRepository.save(employee);

			employee.setId((long)0);
			employee.setName("Employee 4");
			employee.setSalary(18);
			employee.setUsername("employee4");
			employee.setPassword("my-employee-password");
			employee.setRole("EMPLOYEE");
			employeeRepository.save(employee);
		};
	}
}