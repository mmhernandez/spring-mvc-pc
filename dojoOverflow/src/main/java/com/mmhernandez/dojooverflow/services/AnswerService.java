package com.mmhernandez.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.dojooverflow.models.Answer;
import com.mmhernandez.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepo;
	
//	create
	public Answer create(Answer answer) {
		return answerRepo.save(answer);
	}
	
}
