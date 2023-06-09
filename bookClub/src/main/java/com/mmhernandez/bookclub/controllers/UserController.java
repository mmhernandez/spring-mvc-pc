package com.mmhernandez.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.bookclub.models.LoginUser;
import com.mmhernandez.bookclub.models.User;
import com.mmhernandez.bookclub.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
	public String loginReg(
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("newLogin") LoginUser newLogin) {
		return "loginReg.jsp";
	}
	
	
//	REGISTRATION / SIGNUP
	@PostMapping("/signup") 
	public String signupUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model) {
		// check additional validations
		
		User user = userService.register(newUser, result);
		
		//
		return "";
	}
	
	
	
}
