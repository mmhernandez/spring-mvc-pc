package com.mmhernandez.queriesandjoins.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mmhernandez.queriesandjoins.services.MainService;

@Controller
public class MainController {

	@Autowired
	MainService mainService;
	
	@GetMapping("/")
	public String mainPage(
			Model model) {
		
		model.addAttribute("query1", mainService.findSloveneSpeakingCountries());
		model.addAttribute("query2", mainService.findNumberOfCitiesPerCountry());
		model.addAttribute("query3", mainService.findMexicoCitiesWithLargePopulation());
		model.addAttribute("query4", mainService.findProminentLanguagesPerCountry());
		
		return "main.jsp";
	}
}




