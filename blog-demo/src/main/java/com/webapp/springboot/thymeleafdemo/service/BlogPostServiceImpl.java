package com.webapp.springboot.thymeleafdemo.service;

import com.webapp.springboot.thymeleafdemo.dao.BlogPostRepository;
import com.webapp.springboot.thymeleafdemo.dao.UserRepository;
import com.webapp.springboot.thymeleafdemo.entity.BlogPost;
import com.webapp.springboot.thymeleafdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	private UserRepository userRepository;
	private BlogPostRepository blogPostRepository;

	@Autowired
	public BlogPostServiceImpl(BlogPostRepository theBlogPostRepository) {
		blogPostRepository = theBlogPostRepository;
	}

	@Override
	public List<BlogPost> findAll() {
		return blogPostRepository.findAllByOrderByIdAsc();
	}

	@Override
	public BlogPost findById(int theId) {
		Optional<BlogPost> result = blogPostRepository.findById(theId);

		BlogPost theBlogPost = null;

		if (result.isPresent()) {
			theBlogPost = result.get();

			return theBlogPost;
		}
		return null;



	}

	@Override
	public void save(BlogPost theBlogPost) {
		blogPostRepository.save(theBlogPost);
	}

	@Override
	public void deleteById(int theId) {
		blogPostRepository.deleteById(theId);
	}

}






