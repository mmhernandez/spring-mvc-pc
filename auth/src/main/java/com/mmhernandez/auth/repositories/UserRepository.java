package com.mmhernandez.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.auth.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 User findByUsername(String username);
}

