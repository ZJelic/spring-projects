package com.webapp.springboot.thymeleafdemo.dao;

import com.webapp.springboot.thymeleafdemo.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {

	// add a method to sort by id
	public List<BlogPost> findAllByOrderByIdAsc();

	List <BlogPost> findByTitleContainingIgnoreCase(String term);
}
