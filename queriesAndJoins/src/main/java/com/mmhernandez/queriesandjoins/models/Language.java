package com.mmhernandez.queriesandjoins.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="languages")
public class Language {

	@Id
	private String CountryCode;
	private String Language;
	private String IsOfficial;
	private Double Percentage;
	
	
//	CONSTRUCTOR
	public Language() { }


	
//	GETTERS & SETTERS
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getIsOfficial() {
		return IsOfficial;
	}
	public void setIsOfficial(String isOfficial) {
		IsOfficial = isOfficial;
	}
	public Double getPercentage() {
		return Percentage;
	}
	public void setPercentage(Double percentage) {
		Percentage = percentage;
	}
	
	
}
