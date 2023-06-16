package com.mmhernandez.admindashboard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.admindashboard.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
	List<Role> findByName(String name);

}
