package com.mmhernandez.paginationsorting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.paginationsorting.models.Dojo;

@Repository
public interface DojoPagingRepository extends PagingAndSortingRepository<Dojo, Long>{
	
	@Query("SELECT d.name, n.firstName, n.lastName, n.createdAt FROM Dojo d JOIN d.ninjas n")
	Page<Dojo> findAll(Pageable pageable);
	

}
