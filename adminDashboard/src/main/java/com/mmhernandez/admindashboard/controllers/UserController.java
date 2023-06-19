package com.mmhernandez.admindashboard.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmhernandez.admindashboard.models.Role;
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
		User user = userService.getByEmail(email);
		model.addAttribute("currentUser", user);
		
		if(user != null) {
			user.setLastLogin(new Date());
			
			List<Role> userRoles = user.getRoles();
			for(Role role : userRoles) {
				if(role.getName().equals("ROLE_ADMIN") || role.getName().equals("ROLE_SUPERADMIN")) {
					model.addAttribute("users", userService.getAll());
					return "adminHome.jsp";
				} 
			}
		}

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
		
		System.out.println("user count = " + userService.countUsers());
		
		// if validation passes...
		if(userService.countUsers() >= 1) {
			userService.createWithUserRole(user);
		} else {
			userService.createWithAdminRole(user);
		}
		return "redirect:/";
	}
	
	
	
	// login
	@GetMapping("/login")
	public String loginPage(
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model model) {
		if(error != null) {
			System.out.println(error);
			model.addAttribute("errorMessage", "Invalid credentials, please try again");
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Logout successful");
		}
		return "login.jsp";
	}
	
	
}
