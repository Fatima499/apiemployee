package com.zoologie.fr.apiemployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zoologie.fr.apiemployee.model.Employee;
import com.zoologie.fr.apiemployee.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/employee/{id}", produces="application/json")
	public Employee getEmployeeById(@PathVariable Integer id) {
		return this.employeeService.getEmployeeById(id);
	}
	
	@GetMapping(value="/employee/all", produces="application/json")
	public Iterable<Employee> getAllEmployee() {
		return this.employeeService.getAllEmployees();
	}
	
	@DeleteMapping(value="/employee/{id}", produces="application/json")
	public void deleteEmployeeById(@PathVariable Integer id) {
		 this.employeeService.deleteEmployeById(id);
	}
	
	@DeleteMapping(value="/employee/all", produces="application/json")
	public void deleteAllEmployee() {
		 this.employeeService.deleteAllEmployee();
	}
	
}
