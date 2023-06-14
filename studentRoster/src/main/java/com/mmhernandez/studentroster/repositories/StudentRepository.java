package com.mmhernandez.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.studentroster.models.Dorm;
import com.mmhernandez.studentroster.models.Student;
import com.mmhernandez.studentroster.models.Class;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll();
	Long countByDorm(Dorm dorm);
	List<Student> findByDormIsNot(Dorm dorm);
	List<Student> findByClassesEquals(Class cls);
	List<Student> findByClassesNotContains(Class cls);
	
}
