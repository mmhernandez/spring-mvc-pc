package com.mmhernandez.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.queriesandjoins.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{

	@Query(nativeQuery=true, value="""
			SELECT CO.name
			      ,COUNT(CI.id) AS 'number_of_cities'
			FROM cities CI 
			JOIN countries CO ON CO.code = CI.country_code
			GROUP BY CO.name
			ORDER BY COUNT(CI.id) DESC;
			""")
	List<Object[]> findNumberOfCitiesPerCountry();
	
	
	@Query(nativeQuery=true, value="""
			SELECT CI.name
				  ,CI.population
			FROM cities CI 
			JOIN countries CO ON CI.country_code = CO.code
			WHERE CO.name = "Mexico"
				AND CI.population > 500000
			ORDER BY CI.population DESC
			""")
	List<Object[]> findMexicoCitiesWithLargePopulation();
	
	
	@Query(nativeQuery=true, value="""
			SELECT C.name
				  ,L.language
			      ,L.percentage
			FROM languages L
			JOIN countries C ON C.code = L.country_code
			WHERE L.percentage > 89
			ORDER BY L.percentage DESC
			""")
	List<Object[]> findProminentLanguagesPerCountry();
}
