package com.mmhernandez.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mmhernandez.dojooverflow.models.Question;
import com.mmhernandez.dojooverflow.models.Tag;
import com.mmhernandez.dojooverflow.services.QuestionService;
import com.mmhernandez.dojooverflow.services.TagService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	TagService tagService;
	
	
	@GetMapping("/")
	public String dashboard(
			Model model) {
		model.addAttribute("questions", questionService.getAll());
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(
			@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	
	@PostMapping("/questions/add")
	public String addQuestion(
			@Valid @ModelAttribute("question") Question question,
			BindingResult result,
			@RequestParam("tags") String tags,
			RedirectAttributes redirectAttributes) {
		//check normal question validation
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		//add input tags to db appropriately		
		List<Tag> tagList = evaluateTags(tags);
		
		//check tagsList length
		if(tagList == null || tagList.size()>3) {
//			redirectAttributes.addFlashAttribute("tagError", "Must include between 1 and 3 tags");
			result.rejectValue("tags","","Must include between 1 and 3 tags");
			return "newQuestion.jsp";
		}
			
		
		question.setTags(tagList);
		questionService.create(question);
		return "redirect:/";
	}
	
	private List<Tag> evaluateTags(String tags) {
		if(tags.length()> 0 || tags.length()<4) {
			//create empty arrayList
			ArrayList<Tag> tagsArrayList = new ArrayList<Tag>();
			
			//create string array of tag subjects
			String[] tagsList = tags.split(",");
			
			//loop through tagsList array
			for(String eachTag : tagsList) {
				//determine if tag already exists in db
				Tag tag = tagService.getBySubject(eachTag.toLowerCase().strip());
				//if not, add tag to db
				if(tag == null) {
					tag = new Tag(eachTag.toLowerCase().strip());
					tagService.create(tag);
				}
				//append tag to tagsArrayList
				tagsArrayList.add(tag);
			}
			//return arrayList
			return tagsArrayList;
		}
		return null;
	}
	
}
