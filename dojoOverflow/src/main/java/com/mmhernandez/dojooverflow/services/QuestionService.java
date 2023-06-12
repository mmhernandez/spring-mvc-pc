package com.mmhernandez.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mmhernandez.dojooverflow.models.Question;
import com.mmhernandez.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepo;
	
//	get all
	public List<Question> getAll() {
		return questionRepo.findAll();
	}
	
//	validation
	public Question validateQuestion(Question question, BindingResult result) {
		// VALIDATION
		// require at least one tag
		int count = question.getTags().size();
		if(count == 0) {
			result.rejectValue("tags", "", "Must include at least one tag");
		}
		// restrict to 3 tags max
		else if(count > 3) {
			result.rejectValue("tags","","Maximum of 3 tags per question");
		}
		// return null if any errors
		if(result.hasErrors()) {
			return null;
		}
		return question;
		
	}
	
//	create
	public Question create(Question question) {
		return questionRepo.save(question);
	}
	
	
}
