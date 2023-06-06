package com.mmhernandez.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.authentication.models.LoginUser;
import com.mmhernandez.authentication.models.User;
import com.mmhernandez.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	
	@GetMapping("/") 
	public String loginReg(
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("newLogin") LoginUser newLogin) {
		return "loginRegistration.jsp";
	}
	
	@GetMapping("/home") 
	public String home() {
		return "home.jsp";
	}
	
	
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		// Call register method in the service for extra validations
		User user = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			// Send in empty LoginUser when re-rendering the page
            model.addAttribute("newLogin", new LoginUser());
            return "loginRegistration.jsp";
		}
		
		// No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
		
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		// Call login method in the service for extra validations
        User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			//send in empty user when re-rendering the page
			model.addAttribute("newUser", new User());
			return "loginRegistration.jsp";
		}
		
		// No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
		
		return "redirect:/home";
	}
}
