package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Employee;
import com.example.repo.employeeRepo;
import com.example.service.employeeService;
import com.example.service.employeeServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {
	
	@Mock
	private employeeRepo eRepo;
	
	private AutoCloseable autoCloseable;
	
	private employeeService eService;
	
	//Automatically generated test to verify if the application is able to load Spring Boot
	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void setUp() {
		eService = new employeeServiceImpl(eRepo);
	}

	//Test for getAllEmployees method in the service layer
	@Test
	void canGetAllEmployees() throws Exception {
		//when
		eService.getAllEmployees();
		//then
		verify(eRepo).findAll();
		
	}
	
	//Test to verify that repository was involved within the save method
	@Test
	void canAddEmployee() {
		// given
		String email = "mockito@gmail.com";
		Employee employee = new Employee("Mock", 
				"mpassword", email);
		// when
		eService.saveEmployee(employee);
		//then
		ArgumentCaptor<Employee> empArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
		verify(eRepo).save(empArgumentCaptor.capture());
	}
	
	
	

}
