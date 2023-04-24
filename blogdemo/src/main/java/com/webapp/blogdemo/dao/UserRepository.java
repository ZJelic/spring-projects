package com.webapp.blogdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.blogdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// code not needed
	
	// add a method to sort by username
	public List<User> findAllByOrderByUsernameAsc();
	
	// search by name
	public List<User> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
