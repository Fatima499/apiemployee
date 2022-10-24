package com.zoologie.fr.apiemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoologie.fr.apiemployee.model.Employee;
import com.zoologie.fr.apiemployee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployeeById(Integer id) {
		return this.employeeRepository.findById(id).get();
	}
	
	public Iterable<Employee> getListEmployee(Iterable<Integer> ids){
		return employeeRepository.findAllById(ids);
	}

	public Iterable<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	public void saveAllEmployee(Iterable<Employee> listEmployee) {
		this.employeeRepository.saveAll(listEmployee);
	}

	public void deleteEmployeById(Integer id) {
		this.employeeRepository.deleteById(id);
	}
	
	public void deleteEmployee(Employee employee) {
		this.employeeRepository.delete(employee);
	}

	public void deleteAllEmployee() {
		this.employeeRepository.deleteAll();
	}
	
	public void deleteListEmployee(Iterable<Employee> listEmployee) {
		this.employeeRepository.deleteAll(listEmployee);
	}

}
