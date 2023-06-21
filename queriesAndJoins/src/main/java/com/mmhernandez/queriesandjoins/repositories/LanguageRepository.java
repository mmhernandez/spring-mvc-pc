package com.mmhernandez.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.queriesandjoins.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, String>{

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
