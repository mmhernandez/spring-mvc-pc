package com.mmhernandez.safetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mmhernandez.safetravels.models.Expense;
import com.mmhernandez.safetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String expenses(Model model) {
		List<Expense> expenseList = expenseService.findAll();
		model.addAttribute(expenseList);
		return "expenses.jsp";
	}
	
	@GetMapping("/expense")
	public String addExpense(
			@ModelAttribute("expense") Expense expense) {
		return "newExpense.jsp";
	}
	
	@PostMapping("/expense")
	public String createExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newExpense.jsp";
		} else {
			expenseService.create(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expense/{id}")
	public String viewExpense(
			@PathVariable("id") Long id,
			Model model) {
		Expense exp = expenseService.findById(id);
		model.addAttribute(exp);
		return "viewExpense.jsp";
	}
	
	@PutMapping("/expense/{id}")
	public String updateExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute(expense);
			return "viewExpense.jsp";
		} else {
			expenseService.update(expense);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/expense/{id}")
	public String deleteExpense(
			@PathVariable("id") Long id) {
		expenseService.delete(id);
		return "redirect:/";
	}
}
