package com.webapp.springboot.thymeleafdemo.service;

import com.webapp.springboot.thymeleafdemo.dao.PostCommentRepository;
import com.webapp.springboot.thymeleafdemo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {

	private PostCommentRepository postCommentRepository;

	@Autowired
	public PostCommentServiceImpl(PostCommentRepository thePostCommentRepository) {
		postCommentRepository = thePostCommentRepository;
	}

	@Override
	public List<Comment> findByBlogPostId(int id) {
		return postCommentRepository.findByBlogPostId(id);
	}

	@Override
	public List<Comment> findAll() {
		return null;
	}

	@Override
	public Comment findById(int theId) {
		return null;
	}

	@Override
	public void save(Comment comment) {
		postCommentRepository.save(comment);
	}

	@Override
	public void deleteById(int theId) {

	}
}






