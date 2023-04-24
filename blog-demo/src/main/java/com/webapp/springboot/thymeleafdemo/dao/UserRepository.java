package com.webapp.springboot.thymeleafdemo.dao;

import java.util.List;

import com.webapp.springboot.thymeleafdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	// code not needed
	
	// add a method to sort by username
	public List<User> findAllByOrderByUsernameAsc();
	
}
