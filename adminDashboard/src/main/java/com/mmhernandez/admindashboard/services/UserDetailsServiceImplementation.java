package com.mmhernandez.admindashboard.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mmhernandez.admindashboard.models.Role;
import com.mmhernandez.admindashboard.models.User;
import com.mmhernandez.admindashboard.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	
	@Autowired
	UserRepository userRepo;
	
	
	// Finds the user by email. If a user is found, it returns it with the correct authorities. 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByEmail(email); 
        
        if(user == null) {
            throw new UsernameNotFoundException("User not found with this email");
        }
        
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), getAuthorities(user.get()));
    }

	
	// Returns a list of authorities/permissions for a specific user.
	private List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
			}
		
		return authorities;
	}

}
