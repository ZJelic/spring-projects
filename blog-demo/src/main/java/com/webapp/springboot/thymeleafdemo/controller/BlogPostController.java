package com.webapp.springboot.thymeleafdemo.controller;

import com.webapp.springboot.thymeleafdemo.entity.BlogPost;
import com.webapp.springboot.thymeleafdemo.service.BlogPostService;
import com.webapp.springboot.thymeleafdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog-posts")
public class BlogPostController {

	private BlogPostService blogPostService;
	private UserService userService;

	@Autowired
	public BlogPostController(BlogPostService theBlogPostService, UserService theUserService) {
		blogPostService = theBlogPostService;
		userService = theUserService;
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listBlogPosts(Model theModel) {

		List<BlogPost> theBlogPosts = blogPostService.findAll();
		
		// add to the spring model
		theModel.addAttribute("blogPosts", theBlogPosts);
		
		return "blog-form/blog-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		BlogPost theBlogPost = new BlogPost();
		
		theModel.addAttribute("post", theBlogPost);
		
		return "blog-form/add-blog-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("postId") int theId, Model theModel) {
		
		// get the post from the service
		BlogPost theBlogPost = blogPostService.findById(theId);
		
		// set post as a model attribute to pre-populate the form
		theModel.addAttribute("post", theBlogPost);
		
		// send over to form
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
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("postId") int theId) {
		
		// delete the post
		blogPostService.deleteById(theId);
		
		//redirect to /blog-posts/list
		return "redirect:/blog-posts/list";
	}
	@GetMapping("/searchByTitle")
	public String searchByTitle(@RequestParam("searchTerm") String searchTerm, Model model) {
		List<BlogPost> filteredPosts = blogPostService.findByTitleContainingIgnoreCase(searchTerm);
		model.addAttribute("blogPosts", filteredPosts);
		return "blog-form/blog-form";
	}

}


















