package com.mmhernandez.studentroster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.studentroster.models.Student;
import com.mmhernandez.studentroster.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
//	create
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
//	update by id
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
}
