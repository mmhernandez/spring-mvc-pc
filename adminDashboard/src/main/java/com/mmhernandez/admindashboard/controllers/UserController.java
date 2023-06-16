package com.mmhernandez.admindashboard.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mmhernandez.admindashboard.services.UserService;
import com.mmhernandez.admindashboard.validators.UserValidator;

@Controller
public class UserController {

	private UserService userService;
	private UserValidator userValidator;
	
	
//	CONSTRUCTOR
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	
//	MAPPINGS
	@GetMapping(value= {"/", "/home"})
	public String home(
			Principal principal,
			Model model) {
		String email = principal.getName();
		model.addAttribute("currentUser", userService.getByEmail(email));
		return "home.jsp";
	}
	
	// sign up (registration)
	@GetMapping("/signup")
	public String signup() {
		return "signup.jsp";
	}
	
	
	
	
	// login
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
}
