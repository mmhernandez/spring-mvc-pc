package com.mmhernandez.queriesandjoins.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.queriesandjoins.repositories.CityRepository;
import com.mmhernandez.queriesandjoins.repositories.CountryRepository;
import com.mmhernandez.queriesandjoins.repositories.LanguageRepository;

@Service
public class MainService {

	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	LanguageRepository languageRepo;
	

//	get countries that speak Slovene
	public List<Object[]> findSloveneSpeakingCountries() {
		return countryRepo.findCountryWithSloveneLanguage();
	}
	
//	get number of cities per country
	public List<Object[]> findNumberOfCitiesPerCountry() {
		return cityRepo.findNumberOfCitiesPerCountry();
	}
	
//	get Mexico cities with population over 500k
	public List<Object[]> findMexicoCitiesWithLargePopulation() {
		return cityRepo.findMexicoCitiesWithLargePopulation();
	}
	
//	get languages and percentages per city where % is greater than 89
	public List<Object[]> findProminentLanguagesPerCountry() {
		return languageRepo.findProminentLanguagesPerCountry();
	}
	
//	get densly populated countries (population over 100k with a surface area below 501)
	public List<Object[]> findDenselyPopulatedCountries() {
		return countryRepo.findDenselyPopulatedCountries();
	}
	
//	get countries under a constitutional monarchy with a surface area greater than 200 and a life expectancy greater than 75
	public List<Object[]> findCountriesWithHighLifeExpentancy() {
		return countryRepo.findCountriesWithHighLifeExpentancy();
	}
	
//	get Argentina cities in Buenos Aires district with large population
	public List<Object[]> findArgentiaCitiesWithLargePopulation() {
		return cityRepo.findArgentiaCitiesWithLargePopulation();
	}
	
//	get count of countries per region
	public List<Object[]> findCountryCountByRegion() {
		return countryRepo.findCountryCountByRegion();
	}
	
}
