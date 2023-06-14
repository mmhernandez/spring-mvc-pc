package com.mmhernandez.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.studentroster.models.Class;
import com.mmhernandez.studentroster.models.Student;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {
	
	List<Class> findAll();
	List<Class> findByStudentsContains(Student student);
	List<Class> findByStudentsNotContains(Student student);
}
