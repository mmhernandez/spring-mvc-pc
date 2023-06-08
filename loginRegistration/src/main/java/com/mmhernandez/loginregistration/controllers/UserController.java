package com.mmhernandez.loginregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.loginregistration.models.LoginUser;
import com.mmhernandez.loginregistration.models.User;
import com.mmhernandez.loginregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
	public String home(
			HttpSession session,
			Model model) {
		if(session.getAttribute("id") != null) {
			Long userId = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.getById(userId));
			return "home.jsp";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String register(
			@ModelAttribute("newUser") User newUser) {
		return "reg.jsp";
	}
	
	@PostMapping("/register")
	public String createUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			HttpSession session) {
		User user = userService.register(newUser, result);
		if(result.hasErrors()) {
			return "reg.jsp";
		}
		
		session.setAttribute("id", user.getId());
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login(
			@ModelAttribute("newLogin") LoginUser newLogin) {
		return "login.jsp";
	}

	@PostMapping("/login")
	public String loginUser(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			HttpSession session) {
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			return "login.jsp";
		}
		
		session.setAttribute("id", user.getId());
		return "redirect:/";
	}
	
	@GetMapping("/logout") 
	public String logout(
			HttpSession session) {
		if(session.getAttribute("id") != null) {			
			session.removeAttribute("id");
		}
		return "redirect:/";
	}
	
}
