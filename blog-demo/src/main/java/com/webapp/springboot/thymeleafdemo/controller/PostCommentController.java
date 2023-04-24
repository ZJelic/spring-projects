package com.webapp.springboot.thymeleafdemo.controller;

import com.webapp.springboot.thymeleafdemo.entity.Comment;
import com.webapp.springboot.thymeleafdemo.service.PostCommentService;
import com.webapp.springboot.thymeleafdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post-comments")
public class PostCommentController {

	private PostCommentService postCommentService;
	private UserService userService;

	@Autowired
	public PostCommentController(PostCommentService thePostCommentService, UserService theUserService) {
		postCommentService = thePostCommentService;
		userService = theUserService;
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listComments(Model theModel) {
		
		List<Comment> theComments = postCommentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("postComments", theComments);
		
		return "blog-form/blog-form-comments";
	}
	/*
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		BlogPost theBlogPost = new BlogPost();
		
		theModel.addAttribute("post", theBlogPost);
		
		return "blog-form/add-blog-form";
	}

	@PostMapping("/save")
	public String saveBlogPost(@ModelAttribute("post") BlogPost theBlogPost) {

		Date currentDate = new Date();

		BlogPost tempPost = new BlogPost();
		tempPost.setId(theBlogPost.getId());
		tempPost.setTitle(theBlogPost.getTitle());
		tempPost.setContent(theBlogPost.getContent());

		BlogPost dbBlogPost = blogPostService.findById(theBlogPost.getId());
		if (dbBlogPost != null && dbBlogPost.getCreated_at() != null) {
			tempPost.setCreated_at(dbBlogPost.getCreated_at());
		} else {
			tempPost.setCreated_at(currentDate);
		}
		tempPost.setUpdated_at(currentDate);
		tempPost.setUser(userService.findById(1));
		blogPostService.save(tempPost);

		// use a redirect to prevent duplicate submissions
		return "redirect:/blog-posts/list";
	}	*/
}


















