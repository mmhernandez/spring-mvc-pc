package com.mmhernandez.employeesmanagers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.employeesmanagers.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{ 

	List<Employee> getEmployeesByManager(Employee manager);
	Employee getManagerByEmployee(Employee employee);
	
}
