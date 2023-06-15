package com.mmhernandez.auth.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmhernandez.auth.models.User;
import com.mmhernandez.auth.services.UserService;
import com.mmhernandez.auth.validators.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired 
	UserService userService;
	
	private UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
 
	 @RequestMapping("/register")
	 public String registerForm(
			 @Valid @ModelAttribute("user") User user) {
	     return "registration.jsp";
	 }
	 
	 @PostMapping("/register")
     public String registration(
    		 @Valid @ModelAttribute("user") User user, 
    		 BindingResult result, 
    		 Model model, 
    		 HttpSession session) {
		userValidator.validate(user, result);
		
		if (result.hasErrors()) {
            return "registration.jsp";
        }
        userService.saveUserWithAdminRole(user);
        return "redirect:/login";
     }
	 
	 @RequestMapping("/admin")
	    public String adminPage(Principal principal, Model model) {
	        String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        return "adminPage.jsp";
     }
	 
	 @RequestMapping("/login")
	 public String login(
			 @RequestParam(value="error", required=false) String error, 
			 @RequestParam(value="logout", required=false) String logout, 
			 Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "login.jsp";
	  }	
	  
	  @RequestMapping(value = {"/", "/home"})
	    public String home(
	    		Principal principal, 
	    		Model model) {
	        // 1: The home method accepts GET requests for "/" and "/home" URLs. After a successful authentication, 
		  	//	we are able to get the name of our principal (current user) via the .getName() method. 
	        String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        return "home.jsp";
	    }
	 
}

