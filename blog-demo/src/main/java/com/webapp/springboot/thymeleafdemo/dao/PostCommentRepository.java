package com.webapp.springboot.thymeleafdemo.dao;

import com.webapp.springboot.thymeleafdemo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<Comment, Integer> {

	// add a method to find by id
	public List<Comment> findByBlogPostId(int id);
	
}
