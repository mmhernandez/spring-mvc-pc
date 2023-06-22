package com.mmhernandez.employeesmanagers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.employeesmanagers.models.Employee;
import com.mmhernandez.employeesmanagers.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	
//	get employees by manager
	public List<Employee> getEmployeesByManager(Employee manager) {
		return employeeRepo.getEmployeesByManager(manager);
	}
	
//	get manager by employee
	public Employee getManagerByEmployee(Employee employee) {
		return employeeRepo.getManagerByEmployee(employee);
	}
	
}
