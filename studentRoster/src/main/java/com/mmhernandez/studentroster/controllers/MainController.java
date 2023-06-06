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

import com.mmhernandez.studentroster.models.Dorm;
import com.mmhernandez.studentroster.models.Student;
import com.mmhernandez.studentroster.services.DormService;
import com.mmhernandez.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	

	@GetMapping("/")
	public String home() {
		return "redirect:/dorms";
	}
	
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
	
	@GetMapping("/students/new")
	public String newStudent(
			@ModelAttribute("student") Student student,
			Model model) {
		model.addAttribute("dorms", dormService.getAll());
		return "newStudent.jsp";
	}
	
	@GetMapping("/dorms/{dormId}")
	public String dormStudents(
			Model model,
			@PathVariable("dormId") Long dormId,
			@ModelAttribute("student") Student student) {
		model.addAttribute("dorms", dormService.getAll());
		model.addAttribute("dorm", dormService.getById(dormId));
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
			@ModelAttribute("student") Student student,
			@RequestParam("currentDorm") Long currentDormId,
			Model model) {
		model.addAttribute("dorms", dormService.getAll());
		model.addAttribute("dorm", dormService.getById(currentDormId));
		
		studentService.updateStudent(student);
		return "redirect:/dorms/" + currentDormId;
	}
	
	
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(
			@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}
}
