package com.mmhernandez.paginationsorting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmhernandez.paginationsorting.models.Dojo;
import com.mmhernandez.paginationsorting.models.Ninja;
import com.mmhernandez.paginationsorting.services.DojoService;
import com.mmhernandez.paginationsorting.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/pages/1";
	}
	
	@GetMapping("/pages/{pageNumber}")
	public String paginated(
			Model model,
			@PathVariable("pageNumber") int pageNumber) {
		Page<Dojo> dojosAndNinjas = dojoService.getAllDojosAndNinjasPageable(pageNumber - 1);
		int totalPages = dojosAndNinjas.getTotalPages();
		
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pagedList", dojosAndNinjas);		
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(
			@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		
		dojoService.create(dojo);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/ninjas/new")
	public String newNinja(
			Model model,
			@ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.getAll());
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAll());
			return "newNinja.jsp";
		}
		
		ninjaService.create(ninja);
		return "redirect:/";
	}
}
