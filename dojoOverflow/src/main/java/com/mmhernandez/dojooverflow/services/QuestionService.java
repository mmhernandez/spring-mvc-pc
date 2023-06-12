package com.mmhernandez.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
//	get one - by id
	public Question getById(Long id) {
		Optional<Question> oQuestion = questionRepo.findById(id);
		if(oQuestion.isPresent()) {
			return oQuestion.get();
		}
		return null;
	}
	
//	create
	public Question create(Question question) {
		return questionRepo.save(question);
	}
	
	
}
