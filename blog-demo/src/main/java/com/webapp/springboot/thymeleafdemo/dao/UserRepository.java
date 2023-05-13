package com.webapp.springboot.thymeleafdemo.dao;

import com.webapp.springboot.thymeleafdemo.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	// add a method to sort by username
	public List<User> findAllByOrderByUsernameAsc();
	User findByUsername(String username);
	
}
