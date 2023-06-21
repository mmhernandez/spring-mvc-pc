package com.mmhernandez.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.queriesandjoins.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String>{

	@Query(nativeQuery=true, value="""
			SELECT C.name
				  ,L.language
			      ,L.percentage
			FROM countries C
			JOIN languages L ON C.code = L.country_code
			WHERE L.language = "Slovene"
			ORDER BY L.percentage DESC 
			""")
	List<Object[]> findCountryWithSloveneLanguage();
	
	
	@Query(nativeQuery=true, value="""
			SELECT name	
				  ,surface_area
			      ,population
			FROM countries
			WHERE surface_area < 501
				AND population > 100000
			""")
	List<Object[]> findDenselyPopulatedCountries();
	
	
	@Query(nativeQuery=true, value="""
			SELECT name
				  ,government_form
			      ,surface_area
			      ,life_expectancy
			FROM countries
			WHERE government_form = "Constitutional Monarchy"
				AND surface_area > 200
			    AND life_expectancy > 75
			ORDER BY life_expectancy DESC
			""")
	List<Object[]> findCountriesWithHighLifeExpentancy();
	
	
	@Query(nativeQuery=true, value="""
			SELECT region
				  ,COUNT(name) AS "count_countries"
			FROM countries
			GROUP BY region
			ORDER BY COUNT(name) DESC
			""")
	List<Object[]> findCountryCountByRegion();
}
