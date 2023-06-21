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
}
