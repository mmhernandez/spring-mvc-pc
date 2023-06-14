package com.mmhernandez.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.studentroster.models.Class;
import com.mmhernandez.studentroster.models.Student;
import com.mmhernandez.studentroster.repositories.ClassRepository;

@Service
public class ClassService {

	@Autowired
	ClassRepository classRepo;
	
	
//	get all
	public List<Class> getAll() {
		return classRepo.findAll();
	}
	
//	get all by student
	public List<Class> getAllByStudent(Student student) {
		return classRepo.findByStudentsContains(student);
	}
	
//	get all available classes by student
	public List<Class> getAvailableClasses(Student student) {
		return classRepo.findByStudentsNotContains(student);
	}
	
//	get one by id
	public Class getById(Long id) {
		Optional<Class> oClass = classRepo.findById(id);
		if(oClass.isPresent()) {
			return oClass.get();
		}
		return null;
	}
	
//	create
	public Class create(Class cls) {
		return classRepo.save(cls);
	}
	
}
