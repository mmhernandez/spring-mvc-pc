package com.mmhernandez.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mmhernandez.loginregistration.models.LoginUser;
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
		String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPassword);
		
		// save user
		return userRepo.save(newUser);
	}
	
//	get user via login
	public User login(LoginUser newLogin, BindingResult result) {
		// VALIDATION
		//  reject if email does not exist
		Optional<User> oUser = userRepo.findByEmail(newLogin.getEmail());
		if(oUser.isEmpty()) {
			result.rejectValue("email", "Match", "Invalid email and/or password");
		}
		// reject if password does not match db for corresponding email address
		if(oUser.isPresent()) {
			User user = oUser.get();
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				result.rejectValue("password", "Match", "Invalid email and/or password");
			}
			
		}
		// return null if any errors
		if(result.hasErrors()) {
			return null;
		}
		
		// assuming no errors/validation issues, return user
		return oUser.get();
	}
	
	
//	get user by id
	public User getById(Long id) {
		Optional<User> oUser = userRepo.findById(id);
		if(oUser.isPresent()) {
			return oUser.get();
		}
		return null;
	}
	
}
