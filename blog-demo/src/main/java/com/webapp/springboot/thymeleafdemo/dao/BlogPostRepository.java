package com.webapp.springboot.thymeleafdemo.dao;

import com.webapp.springboot.thymeleafdemo.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {

	// code not needed
	
	// add a method to sort by id
	public List<BlogPost> findAllByOrderByIdAsc();

	
}
