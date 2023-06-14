package com.mmhernandez.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.studentroster.models.Dorm;
import com.mmhernandez.studentroster.models.Student;
import com.mmhernandez.studentroster.models.Class;
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
	
//	count students by dorm
	public Long countStudentByDorm(Dorm dorm) {
		return studentRepository.countByDorm(dorm);
	}
	
//	get all not in dorm
	public List<Student> getAllNotInDorm(Dorm dorm) {
		return studentRepository.findByDormIsNot(dorm);
	}
	
//	get all in class
	public List<Student> getAllInClass(Class cls) {
		return studentRepository.findByClassesEquals(cls);
	}
	
//	get all not in class
	public List<Student> getAllNotInClass(Class cls) {
		return studentRepository.findByClassesNotContains(cls);
	}
	
}
