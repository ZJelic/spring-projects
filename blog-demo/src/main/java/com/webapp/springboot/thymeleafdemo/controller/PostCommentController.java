package com.webapp.springboot.thymeleafdemo.controller;

import com.webapp.springboot.thymeleafdemo.entity.Comment;
import com.webapp.springboot.thymeleafdemo.entity.User;
import com.webapp.springboot.thymeleafdemo.service.BlogPostService;
import com.webapp.springboot.thymeleafdemo.service.PostCommentService;
import com.webapp.springboot.thymeleafdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/post-comments")
public class PostCommentController {

	private PostCommentService postCommentService;
	private UserService userService;
	private BlogPostService blogPostService;

	@Autowired
	public PostCommentController(PostCommentService thePostCommentService, UserService theUserService,
								 BlogPostService theBlogPostService) {
		postCommentService = thePostCommentService;
		userService = theUserService;
		blogPostService = theBlogPostService;
	}
	
	// add mapping for "/list"
	@GetMapping("/showComments")
	public String showComments(@RequestParam("postId") int theId, Model theModel) {
		
		List<Comment> theComments = postCommentService.findByBlogPostId(theId);
		
		// add to the spring model
		theModel.addAttribute("postComments", theComments);
		theModel.addAttribute("postId", theId);

		return "blog-form/blog-form-comments";
	}
	@GetMapping("/showFormForAddComment")
	public String showFormForAddComments(@RequestParam("postId") int theId, Model theModel) {

		// create model attribute to bind form data
		Comment theComment = new Comment();

		theModel.addAttribute("postComment", theComment);
		theModel.addAttribute("postId", theId);

		return "blog-form/add-blog-form-comment";
	}

	@PostMapping("/saveComment")
	public String saveComment(@RequestParam("postId") int theId,
							  @ModelAttribute("postComment") Comment theComment) {

		Date currentDate = new Date();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;

		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		User user = userService.findByUsername(username);

		Comment tempComment = new Comment();
		tempComment.setId(theComment.getId());
		tempComment.setContent(theComment.getContent());
		tempComment.setCreated_at(currentDate);
		tempComment.setUpdated_at(currentDate);
		tempComment.setUser(user);
		tempComment.setBlogPost(blogPostService.findById(theId));
		postCommentService.save(tempComment);

		// use a redirect to prevent duplicate submissions
		return "redirect:/post-comments/showComments?postId=" + theId;
	}

}


















