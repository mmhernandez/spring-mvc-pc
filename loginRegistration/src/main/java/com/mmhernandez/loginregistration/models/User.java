package com.mmhernandez.loginregistration.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="First name required")
	@Size(min=2, max=45, message="First name must be between 2 and 45 characters")
	private String firstName;
	
	@NotBlank(message="Last name required")
	@Size(min=2, max=45, message="Last name must be between 2 and 45 characters")
	private String lastName;
	
	@Past(message="Invalid birthday")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	@NotNull(message="Marital status required")
	private String maritalStatus;
	
	@NotNull(message="Pet selection required")
	@Min(value=0)
	@Max(value=4)
	private Integer numPets;
	
	@NotBlank(message="Email required")
	@Email(message="Invalid email")
	private String email;
	
	@NotEmpty(message="Password required")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	private String password;
	
	@Transient
	@NotBlank(message="Password confirmation required")
	private String confirmPassword;
	
	@AssertTrue(message="You must agree to the terms and conditions to continue")
	private Boolean agreeToTerms;	//check box
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
//	CONSTRUCTORS
	public User() { }
	public User(String firstName, String lastName, Date birthday, String maritalStatus, Integer numPets, String email, String password, String confirmPassword, Boolean agreeToTerms) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.maritalStatus = maritalStatus;
		this.numPets = numPets;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.agreeToTerms = agreeToTerms;
	}
	
	
//	GETTERS & SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Integer getNumPets() {
		return numPets;
	}
	public void setNumPets(Integer numPets) {
		this.numPets = numPets;
	}
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Boolean getAgreeToTerms() {
		return agreeToTerms;
	}
	public void setAgreeToTerms(Boolean agreeToTerms) {
		this.agreeToTerms = agreeToTerms;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
//	OTHER METHODS
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
