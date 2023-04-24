package com.webapp.springboot.thymeleafdemo.service;

import com.webapp.springboot.thymeleafdemo.dao.BlogPostRepository;
import com.webapp.springboot.thymeleafdemo.dao.PostCommentRepository;
import com.webapp.springboot.thymeleafdemo.dao.UserRepository;
import com.webapp.springboot.thymeleafdemo.entity.BlogPost;
import com.webapp.springboot.thymeleafdemo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PostCommentServiceImpl implements PostCommentService {

	private PostCommentRepository postCommentRepository;

	@Autowired
	public PostCommentServiceImpl(PostCommentRepository thePostCommentRepository) {
		postCommentRepository = thePostCommentRepository;
	}


	@Override
	public Set<Comment> findAll() {
		return postCommentRepository.findAllByOrderByUsernameAsc();
	}

	@Override
	public Comment findById(int theId) {
		return null;
	}

	@Override
	public void save(Comment theBlogPost) {

	}

	@Override
	public void deleteById(int theId) {

	}
}






