package com.mmhernandez.admindashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.admindashboard.models.Role;
import com.mmhernandez.admindashboard.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepo;
	
//	get by name
	public List<Role> getByName(String name) {
		return roleRepo.findByName(name);
	}
}
