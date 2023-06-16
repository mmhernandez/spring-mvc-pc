package com.mmhernandez.admindashboard.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mmhernandez.admindashboard.models.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> c) {
		return User.class.equals(c);
	}
	
	@Override
	public void validate(Object o, Errors e) {
		User user = (User) o;
		if(!user.getConfirmPassword().equals(user.getPassword())) {
			e.rejectValue("confirmPassword", "Match");
		}
	}
	
}
