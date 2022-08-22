package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Employee;
import com.example.repo.employeeRepo;
import com.example.service.employeeService;

@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired
	private employeeRepo eRepo;
	
	@Autowired
	private employeeService eService;
	
	
	
}
