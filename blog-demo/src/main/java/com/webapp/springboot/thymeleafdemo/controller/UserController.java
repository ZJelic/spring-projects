package com.webapp.springboot.thymeleafdemo.controller;

import com.webapp.springboot.thymeleafdemo.entity.*;
import com.webapp.springboot.thymeleafdemo.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		List<User> theUsers = userService.findAll();
		
		// add to the spring model
		theModel.addAttribute("users", theUsers);
		
		return "users/list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "users/user-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
		
		// get the user from the service
		User theUser = userService.findById(theId);
		
		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);
		
		// send over to form
		return "users/user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		// save the user
		userService.save(theUser);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("userId") int theId) {
		
		// delete the user
		userService.deleteById(theId);
		
		//redirect to /users/list
		return "redirect:/users/list";
	}
	
}


















