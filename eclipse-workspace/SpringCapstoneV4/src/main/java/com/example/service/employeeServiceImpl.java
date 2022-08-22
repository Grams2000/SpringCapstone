package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repo.employeeRepo;

@Service
public class employeeServiceImpl implements employeeService{

	
	@Autowired
	private employeeRepo cRepo;
	
	
	
	public employeeServiceImpl(employeeRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return cRepo.findAll();
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = cRepo.findById(id);
		
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id ::" + id);
		}
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.cRepo.save(employee);
		
	}

	@Override
	public void deleteEmployeeById(int id) {
		this.cRepo.deleteById(id);
		
	}
	
	
	
	
	

}
