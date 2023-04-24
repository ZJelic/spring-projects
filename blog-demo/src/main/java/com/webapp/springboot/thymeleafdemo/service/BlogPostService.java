package com.webapp.springboot.thymeleafdemo.service;

import com.webapp.springboot.thymeleafdemo.entity.BlogPost;
import com.webapp.springboot.thymeleafdemo.entity.User;

import java.util.List;

public interface BlogPostService {

	public List<BlogPost> findAll();
	
	public BlogPost findById(int theId);

	
	public void save(BlogPost theBlogPost);
	
	public void deleteById(int theId);

	
}
