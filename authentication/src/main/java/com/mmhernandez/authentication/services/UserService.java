package com.mmhernandez.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mmhernandez.authentication.models.LoginUser;
import com.mmhernandez.authentication.models.User;
import com.mmhernandez.authentication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	
	public User register(User newUser, BindingResult result) {
		
		// Reject if email is taken (present in database)
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Availability", "Email already in use");
		}
		
		// Reject if password doesn't match confirmation
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Passwords do not match");
		}
		
		// Reject if result has errors
		if(result.hasErrors()) {
			return null;
		}
    
		// Assuming no errors or reasons to reject registration,
        // 	 hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		
		// Reject if email is not in database
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email","Login","Email and/or password incorrect");
		} 
		
		if(potentialUser.isPresent()) {
			User user = potentialUser.get();
			// Reject if BCrypt password match fails
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				result.rejectValue("password", "Matches", "Email and/or password incorrect");	
			}
		}
    
        // Return null if result has errors
		if(result.hasErrors()) {
			return null;
		}
		
        // Otherwise, return the user object
		return potentialUser.get();
	}
	
}
