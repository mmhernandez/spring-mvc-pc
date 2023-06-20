package com.mmhernandez.admindashboard.services;

import java.util.List;
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
	
//	create with super admin role
	public void createWithSuperAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_SUPERADMIN"));
		userRepo.save(user);
	}
	
//	update user
	public void updateUser(User user) {
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
	
//	get by id
	public User getById(Long id) {
		Optional<User> oUser = userRepo.findById(id);
		if(oUser.isPresent()) {
			return oUser.get();
		}
		return null;
	}
	
//	get all
	public List<User> getAll() {
		return userRepo.findAll();
	}

	
//	count users
	public Long countUsers() {
		return userRepo.count();
	}
	
//	delete user by id
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}
	
	
}
