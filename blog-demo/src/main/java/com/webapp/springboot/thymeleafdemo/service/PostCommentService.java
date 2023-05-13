package com.webapp.springboot.thymeleafdemo.service;

import com.webapp.springboot.thymeleafdemo.entity.Comment;

import java.util.List;

public interface PostCommentService {

	public List<Comment> findAll();
	
	public Comment findById(int theId);

	
	public void save(Comment comment);
	
	public void deleteById(int theId);

	public List<Comment> findByBlogPostId(int id);
}