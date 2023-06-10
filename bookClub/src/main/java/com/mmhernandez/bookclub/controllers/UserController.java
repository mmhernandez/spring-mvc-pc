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
import com.mmhernandez.bookclub.services.BookService;
import com.mmhernandez.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/")
	public String root() {
		return "redirect:/login";
	}
	
	@GetMapping("/books")
	public String dashboard(
			HttpSession session,
			Model model) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("books", bookService.getAll());
		return "dashboard.jsp";
	}
	
	
//	REGISTRATION / SIGNUP
	@GetMapping("/signup") 
	public String signupPage(
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("newLogin") LoginUser newLogin,
			HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "loginReg.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping("/signup") 
	public String signupUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		// check validations, if errors, reload loginReg page
		User user = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "loginReg.jsp";
		}
		
		// if no validation errors, add user to session and redirect to dashboard
		session.setAttribute("user", user);
		return "redirect:/books";
	}
	
	@GetMapping("/login")
	public String loginReg(
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("newLogin") LoginUser newLogin,
			HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "loginReg.jsp";
		}
		return "redirect:/books";
	}
	
	@PostMapping("/login") 
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session) {
		// check validations, if errors, reload loginReg page
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "loginReg.jsp";
		}
		
		// if no validation errors, add user to session and redirect to dashboard
		session.setAttribute("user", user);
		return "redirect:/books";
	}
	
	
//	LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
