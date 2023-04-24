package com.webapp.springboot.thymeleafdemo.service;

import java.util.List;

import com.webapp.springboot.thymeleafdemo.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
	
}
