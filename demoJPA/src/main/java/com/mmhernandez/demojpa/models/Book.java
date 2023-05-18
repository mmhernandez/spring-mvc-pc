package com.mmhernandez.demojpa.models;

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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@NotNull @Size(min=5, max=255) private String title;
	@NotNull @Size(min=5, max=255) private String description;
	@NotNull @Size(min=3, max=45) private String language;
	@NotNull @Min(100) private Integer numberOfPages;
	@Column(updatable=false) @DateTimeFormat(pattern="yyy-MM-dd") private Date createdAt;
	@DateTimeFormat(pattern="yyy-MM-dd") private Date updatedAt;

//	CONSTRUCTORS
	public Book() {	}
	public Book(String title, String description, String language, Integer pages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = pages;
	}
	
//	GETTERS & SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
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
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
