package com.mmhernandez.studentroster.services;

import java.util.Optional;

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
	
//	update
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
//	get one by id
	public Student getById(Long id) {
		Optional<Student> optStudent = studentRepository.findById(id);
		if(optStudent.isPresent()) {
			return optStudent.get();
		}
		return null;
	}
	
//	delete by id
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
//	delete by student
	public void deleteStudentObj(Student student) {
		studentRepository.delete(student);
	}
	
}
