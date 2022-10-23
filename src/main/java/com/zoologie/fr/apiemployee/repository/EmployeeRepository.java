package com.zoologie.fr.apiemployee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zoologie.fr.apiemployee.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
