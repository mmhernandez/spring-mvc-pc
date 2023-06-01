package com.mmhernandez.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.safetravels.models.Expense;
import com.mmhernandez.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
//	CONSTRUCTORS
	public ExpenseService() {}
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
//	OTHER METHODS
//	get one by id
	public Expense findById(Long id) {
		Optional<Expense> optExp = expenseRepository.findById(id);
		if(optExp.isPresent()) {
			return optExp.get();
		} else {
			return null;
		}
	}
	
//	get all
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}
	
//	create
	public Expense create(Expense expense) {
		return expenseRepository.save(expense);
	}
	
//	update
	public Expense update(Expense expense) {
		return expenseRepository.save(expense);
	}
	
//	delete by id
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}
	
}
