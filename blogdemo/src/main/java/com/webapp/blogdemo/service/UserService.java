package com.webapp.blogdemo.service;

import java.util.List;

import com.webapp.blogdemo.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
	
	public List<User> searchBy(String theName);
	
}
