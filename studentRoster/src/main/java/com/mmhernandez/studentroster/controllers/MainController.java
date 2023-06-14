package com.mmhernandez.studentroster.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmhernandez.studentroster.models.Class;
import com.mmhernandez.studentroster.models.Dorm;
import com.mmhernandez.studentroster.models.Student;
import com.mmhernandez.studentroster.services.DormService;
import com.mmhernandez.studentroster.services.StudentService;
import com.mmhernandez.studentroster.services.ClassService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ClassService classService;
	
	

	@GetMapping("/")
	public String home() {
		return "redirect:/dorms";
	}
	
	
//	DORM MAPPINGS
	@GetMapping("/dorms")
	public String dashboard(
			Model model) {
		model.addAttribute("dorms", dormService.getAll());
		
		//get student count for each dorm
		List<Dorm> dormList = dormService.getAll();
		HashMap<Long, Long> studentCountByDorm = new HashMap<Long, Long>();
		for(int i=0; i<dormList.size();i++) {
			Long dormId = dormList.get(i).getId();
			Long studentCount = studentService.countStudentByDorm(dormList.get(i));
			studentCountByDorm.put(dormId, studentCount);
		}
		model.addAttribute("students", studentCountByDorm);
		return "dashboard.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String newDorm(
			@ModelAttribute("dorm") Dorm dorm) {
		return "newDorm.jsp";
	}
	
	@GetMapping("/dorms/{dormId}")
	public String dormStudents(
			Model model,
			@PathVariable("dormId") Long dormId,
			@ModelAttribute("student") Student student) {
		Dorm thisDorm = dormService.getById(dormId);
		model.addAttribute("dorms", dormService.getAll());
		model.addAttribute("dorm", thisDorm);
		model.addAttribute("availableStudents", studentService.getAllNotInDorm(thisDorm));
		return "dormStudents.jsp";
	}
	
	@PostMapping("/dorms/create")
	public String createDorm(
			@Valid @ModelAttribute("dorm") Dorm dorm,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newDorm.jsp";
		}
		dormService.createDorm(dorm);
		return "redirect:/";
	}
	
	
//	STUDENT MAPPINGS	
	@GetMapping("/students/new")
	public String newStudent(
			@ModelAttribute("student") Student student,
			Model model) {
		model.addAttribute("dorms", dormService.getAll());
		return "newStudent.jsp";
	}
	
	@GetMapping("/students/{id}")
	public String studentClasses(
			@PathVariable("id") Long studentId,
			Model model) {
		Student student = studentService.getById(studentId);
		model.addAttribute("student", student);
		model.addAttribute("classes", classService.getAllByStudent(student));
		model.addAttribute("availableClasses", classService.getAvailableClasses(student));
		return "studentClasses.jsp";
	}	
	
	
	
	@PostMapping("/students/create")
	public String createStudent(
			@Valid @ModelAttribute("student") Student student,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dorms", dormService.getAll());
			return "newStudent.jsp";
		}
		studentService.createStudent(student);
		return "redirect:/";
	}
		
	@PutMapping("/students")
	public String updateStudentDorm(
			@RequestParam("student") Student student,
			@RequestParam("currentDorm") Long currentDormId,
			Model model) {
		Dorm thisDorm = dormService.getById(currentDormId);
		model.addAttribute("dorms", dormService.getAll());
		model.addAttribute("dorm", thisDorm);
		
		student.setDorm(thisDorm);
		studentService.updateStudent(student);
		return "redirect:/dorms/" + currentDormId;
	}
	
	@PutMapping("/students/reassign")
	public String updateStudentDormReassign(
			@RequestParam("currentDorm") Long currentDormId,
			@RequestParam("id") Long studentId,
			@RequestParam("dorm") Dorm dorm,
			Model model) {
		model.addAttribute("dorms", dormService.getAll());
		model.addAttribute("dorm", dormService.getById(currentDormId));
		
		Student student = studentService.getById(studentId);
		student.setDorm(dorm);
		studentService.updateStudent(student);
		return "redirect:/dorms/" + currentDormId;
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(
			@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}
	
	
//	CLASS MAPPINGS	
	@GetMapping("/classes/new")
	public String newClass(
			@ModelAttribute("cls") Class cls) {
		return "newClass.jsp";
	}
	
	@GetMapping("/classes/all")
	public String viewAllClasses(
			Model model) {
		model.addAttribute("classes", classService.getAll());
		return "allClasses.jsp";
	}
	
	@GetMapping("/classes/{id}")
	public String classStudents(
			Model model,
			@PathVariable("id") Long classId) {
		Class cls = classService.getById(classId);
		model.addAttribute("cls", cls);
		model.addAttribute("classStudents", studentService.getAllInClass(cls));
		model.addAttribute("availableStudents", studentService.getAllNotInClass(cls));
		return "classStudents.jsp";
	}
	
	@PostMapping("/classes/create") 
	public String createClass(
			@Valid @ModelAttribute("cls") Class cls,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newClass.jsp";
		}
		classService.create(cls);
		return "redirect:/classes/all";
	}
	
	@PutMapping("/classes")
	public String updateClassStudents(
			@RequestParam("student") Long studentId,
			@RequestParam("cls") Long classId,
			@RequestParam("redirect") String redirectPreference) {
		Student student = studentService.getById(studentId);
		Class cls = classService.getById(classId);
		
		student.getClasses().add(cls);
		studentService.updateStudent(student);
		if(redirectPreference.equals("class")) {			
			return "redirect:/classes/" + classId;
		}
		return "redirect:/students/" + studentId;
	}
	
	@PutMapping("/classes/{id}") 
	public String dropClass(
			@PathVariable("id") Long classId,
			@RequestParam("studentId") Long studentId) {
		Class cls = classService.getById(classId);
		Student student = studentService.getById(studentId);

		int clsIdx = student.getClasses().indexOf(cls);
		student.getClasses().remove(clsIdx);
		studentService.updateStudent(student);
		return "redirect:/students/" + studentId;
	}
}



