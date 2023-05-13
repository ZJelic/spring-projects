package com.webapp.springboot.thymeleafdemo.service;

import com.webapp.springboot.thymeleafdemo.entity.User;

import java.util.List;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);

	public User findByUsername(String username);
	
}
