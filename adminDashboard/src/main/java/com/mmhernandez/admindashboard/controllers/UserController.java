package com.mmhernandez.admindashboard.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.admindashboard.models.User;
import com.mmhernandez.admindashboard.services.UserService;
import com.mmhernandez.admindashboard.validators.UserValidator;

import jakarta.validation.Valid;

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
		System.out.println("email = " + email);
		model.addAttribute("currentUser", userService.getByEmail(email));
		return "home.jsp";
	}
	
	
	// sign up (registration)
	@GetMapping("/signup")
	public String signupPage(
			@ModelAttribute("user") User user) {
		System.out.println(userService.countUsers());
		return "signup.jsp";
	}
	
	@PostMapping("/signup")
	public String signup(
			@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		
		// validate registration attempt
		userValidator.validate(user, result);
		if(userService.getByEmail(user.getEmail()) != null) {
			result.rejectValue("email", "ExistsCheck");
		}
		if(result.hasErrors()) {
			return "signup.jsp";
		}
		
		// if validation passes...
		if(userService.countUsers() > 1) {
			userService.createWithUserRole(user);
		} else {
			userService.createWithAdminRole(user);
		}
		return "redirect:/";
	}
	
	
	
	
	// login
	@GetMapping("/login")
	public String loginPage() {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String login() {
		return "";
	}
	
}
