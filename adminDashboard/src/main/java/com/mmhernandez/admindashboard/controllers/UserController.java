package com.mmhernandez.admindashboard.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmhernandez.admindashboard.models.Role;
import com.mmhernandez.admindashboard.models.User;
import com.mmhernandez.admindashboard.services.UserService;
import com.mmhernandez.admindashboard.validators.UserValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
			HttpSession session,
			Model model) {
		String email = principal.getName();
		User user = userService.getByEmail(email);
		session.setAttribute("currentUser", user);
		model.addAttribute("currentUser", session.getAttribute("currentUser"));
		
		if(user != null) {
			user.setLastLogin(new Date());
			userService.updateUser(user);
			
			
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
		return "signup.jsp";
	}
	
	@PostMapping("/signup")
	public String signup(
			@Valid @ModelAttribute("user") User user,
			BindingResult result,
			HttpServletRequest request,
			HttpSession session) {
		
		// validate registration attempt
		userValidator.validate(user, result);
		if(userService.getByEmail(user.getEmail()) != null) {
			result.rejectValue("email", "ExistsCheck");
		}
		if(result.hasErrors()) {
			return "signup.jsp";
		}
		
		// if validation passes...
		String password = user.getPassword();  //store the pw before it gets encrypted
		if(userService.countUsers() >= 1) {
			userService.createWithUserRole(user);
		} else {
			userService.createWithSuperAdminRole(user);
		}
		
		authWithHttpServletRequest(request, user.getEmail(), password);
		return "redirect:/";
	}
	
	public void authWithHttpServletRequest(HttpServletRequest request, String email, String password) {
		try {
			request.login(email, password);
		} catch (ServletException e) {
			System.out.println("Error while logging in" + e);
		}
	}
	
	
	
	// login (post mapping rolled into spring security functionality)
	@GetMapping("/login")
	public String loginPage(
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model model) {
		if(error != null) {
			model.addAttribute("errorMessage", "Invalid credentials, please try again");
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Logout successful");
		}
		return "login.jsp";
	}
	
	
	// delete user
	@GetMapping("/user/delete/{id}")
	public String deleteUser(
			@PathVariable("id") Long id,
			Principal principal,
			Model model) {
		if(principal == null) {
			return "redirect:/";
		}
		userService.deleteById(id);
		return "redirect:/";
	}
	
}
