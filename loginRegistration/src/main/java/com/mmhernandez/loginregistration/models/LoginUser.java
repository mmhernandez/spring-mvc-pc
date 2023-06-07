package com.mmhernandez.loginregistration.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
	@NotBlank(message="Email required")
	@Email(message="Invalid email")
	private String email;
	
	@NotBlank(message="Password required")
	@Size(min=8, max=28, message="Password must be between 8 and 28 characters")
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
