package com.mmhernandez.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mmhernandez.bookclub.models.LoginUser;
import com.mmhernandez.bookclub.models.User;
import com.mmhernandez.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	
//	create/get user via signup
	public User register(User newUser, BindingResult result) {
		// VALIDATION
		// reject if email already exists in db
			Optional<User> oUser = userRepo.findByEmail(newUser.getEmail());
			if(oUser.isPresent()) {
				result.rejectValue("email", "", "Email already in use");
			}
		// reject if password and confirmPassword do not match
			if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
				result.rejectValue("confirmPassword", "", "Passwords do not match");
			}
		// return null if any validation issues
			if(result.hasErrors()) {
				return null;
			}
		
		// if no validation issues present, hash and update password
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
			
		// save to db and return user
			return userRepo.save(newUser);
	}
	
	
//	get user via login
	public User login(LoginUser newLogin, BindingResult result) {
		// VALIDATION
		// reject if email does not exist in db
			Optional<User> oUser = userRepo.findByEmail(newLogin.getEmail());
			if(oUser.isEmpty()) {
				result.rejectValue("password", "", "Email and/or password invalid");
			}
		// reject if pw does not match db entry for matching email
			else {
				if(!BCrypt.checkpw(newLogin.getPassword(), oUser.get().getPassword())) {
					result.rejectValue("password", "", "Email and/or password invalid");
				}
			}
		// return null if any validation issues
			if(result.hasErrors()) {
				return null;
			}
		
		// if no validation issues, return user
			return oUser.get();
	}
	
	
}
