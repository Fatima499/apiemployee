package com.zoologie.fr.apiemployee.controller;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zoologie.fr.apiemployee.model.Employee;
import com.zoologie.fr.apiemployee.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * GET a employee by id
	 * @param id
	 * @return a employee
	 */
	@GetMapping(value="/employees/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		return this.employeeService.getEmployeeById(id);
	}
	
	/**
	 * GET all employees
	 * @return a Iterable that contains all employess
	 */
	@GetMapping(value="/employees")
	public Iterable<Employee> getAllEmployee() {
		return this.employeeService.getAllEmployees();
	}
	
	/**
	 * POST : create a new employee
	 * @param employee
	 * @return a creation code 201 and URI to created resource
	 */
	@PostMapping(value="/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee ) {
		Employee employeeAdded = this.employeeService.saveEmployee(employee);
		if(Objects.isNull(employeeAdded)) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employeeAdded.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	/**
	 * PUT : update a employee
	 * @param employee
	 */
	@PutMapping(value="employees")
	private void updateEmployee(@RequestBody Employee employee) {
		this.employeeService.saveEmployee(employee);
	}
	
	/**
	 * Delete a employee
	 * @param id
	 */
	@DeleteMapping(value="/employees/{id}")
	public void deleteEmployeeById(@PathVariable Integer id) {
		 this.employeeService.deleteEmployeById(id);
	}
	
	/**
	 * Delete all empoyees
	 */
	@DeleteMapping(value="/employees")
	public void deleteAllEmployee() {
		 this.employeeService.deleteAllEmployee();
	}
	
}
