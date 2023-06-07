package com.mmhernandez.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mmhernandez.loginregistration.models.User;
import com.mmhernandez.loginregistration.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	
//	create user via registration
	public User register(User newUser, BindingResult result) {
		// VALIDATION
		// reject if email already in db
		Optional<User> oUser = userRepo.findByEmail(newUser.getEmail());
		if(oUser.isPresent()) {
			result.rejectValue("email", "AlreadyRegistered", "Email already in use");
		}
		// reject if password/confirmPassword do not match
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Match", "Passwords do not match");
		}
		// return null if any errors
		if(result.hasErrors()) {
			return null;
		}
		
		// assuming no errors/validation issues, hash and set the password
		newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
		
		// save user
		return userRepo.save(newUser);
	}
	
//	get user via login
	
}
