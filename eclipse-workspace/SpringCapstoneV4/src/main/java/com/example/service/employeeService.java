package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface employeeService{
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	void saveEmployee(Employee employee);
	
	void deleteEmployeeById(int id);
	

	
	
}
