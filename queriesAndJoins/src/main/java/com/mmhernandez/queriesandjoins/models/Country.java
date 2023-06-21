package com.mmhernandez.queriesandjoins.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="countries")
public class Country {

	@Id
	private String Code;
	private String Name;
	private String Continent;
	private String Region;
	private Double SurfaceArea;
	private Integer IndepYear;
	private Integer Population;
	private Double LifeExpectancy;
	private Double GNP;
	private Double GNPOld;
	private String LocalName;
	private String GovernmentForm;
	private String HeadOfState;
	private Integer Capital;
	private String Code2;
	
	
//	CONSTRUCTOR
	public Country() { }


//	GETTERS & SETTERS
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public Double getSurfaceArea() {
		return SurfaceArea;
	}
	public void setSurfaceArea(Double surfaceArea) {
		SurfaceArea = surfaceArea;
	}
	public Integer getIndepYear() {
		return IndepYear;
	}
	public void setIndepYear(Integer indepYear) {
		IndepYear = indepYear;
	}
	public Integer getPopulation() {
		return Population;
	}
	public void setPopulation(Integer population) {
		Population = population;
	}
	public Double getLifeExpectancy() {
		return LifeExpectancy;
	}
	public void setLifeExpectancy(Double lifeExpectancy) {
		LifeExpectancy = lifeExpectancy;
	}
	public Double getGNP() {
		return GNP;
	}
	public void setGNP(Double gNP) {
		GNP = gNP;
	}
	public Double getGNPOld() {
		return GNPOld;
	}
	public void setGNPOld(Double gNPOld) {
		GNPOld = gNPOld;
	}
	public String getLocalName() {
		return LocalName;
	}
	public void setLocalName(String localName) {
		LocalName = localName;
	}
	public String getGovernmentForm() {
		return GovernmentForm;
	}
	public void setGovernmentForm(String governmentForm) {
		GovernmentForm = governmentForm;
	}
	public String getHeadOfState() {
		return HeadOfState;
	}
	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}
	public Integer getCapital() {
		return Capital;
	}
	public void setCapital(Integer capital) {
		Capital = capital;
	}
	public String getCode2() {
		return Code2;
	}
	public void setCode2(String code2) {
		Code2 = code2;
	}
	
}
