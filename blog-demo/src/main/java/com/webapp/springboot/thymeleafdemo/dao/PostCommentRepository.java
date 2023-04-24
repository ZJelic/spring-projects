package com.webapp.springboot.thymeleafdemo.dao;

import com.webapp.springboot.thymeleafdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PostCommentRepository extends JpaRepository<User, Integer> {

	// code not needed
	
	// add a method to sort by username
	public Set<User> findAllByOrderByUsernameAsc();
	
}
