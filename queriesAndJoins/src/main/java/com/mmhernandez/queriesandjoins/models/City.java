package com.mmhernandez.queriesandjoins.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cities")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	private String Name;
	private String CountryCode;
	private String District;
	private Integer Population;
	
	
//	CONSTRUCTOR
	public City() { }


//	GETTERS & SETTERS
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public Integer getPopulation() {
		return Population;
	}
	public void setPopulation(Integer population) {
		Population = population;
	}
	
	
}
