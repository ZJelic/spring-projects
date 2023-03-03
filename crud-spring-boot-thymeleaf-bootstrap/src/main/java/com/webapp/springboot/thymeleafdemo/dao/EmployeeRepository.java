package com.webapp.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// code not needed
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
