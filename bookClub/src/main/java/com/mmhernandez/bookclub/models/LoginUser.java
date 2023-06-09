package com.mmhernandez.bookclub.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {

	@NotEmpty(message="Email required")
	@Email(message="Invalid email")
	private String email;
	
	@NotEmpty(message="Password required")
	@Size(min=8, max=255, message="Password must be at least 8 characters")
	private String password;
	
	
//	CONSTRUCTORS
	public LoginUser() { }
	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
//	GETTERS & SETTERS
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
