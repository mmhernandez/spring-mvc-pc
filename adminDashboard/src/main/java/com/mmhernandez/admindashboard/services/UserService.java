package com.mmhernandez.admindashboard.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmhernandez.admindashboard.models.User;
import com.mmhernandez.admindashboard.repositories.RoleRepository;
import com.mmhernandez.admindashboard.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
//	CONSTRUCTOR
	public UserService(UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
//	create with user role
	public void createWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepo.save(user);
	}
	
//	create with admin role
	public void createWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
		userRepo.save(user);
	}
	
//	get by email
	public User getByEmail(String email) {
		Optional<User> oUser = userRepo.findByEmail(email);
		if (oUser.isPresent()	 ) {
			return oUser.get();
		}
		return null;
	}
	
	
}