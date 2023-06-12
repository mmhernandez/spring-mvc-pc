package com.mmhernandez.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.dojooverflow.models.Tag;
import com.mmhernandez.dojooverflow.repositories.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagRepo;
	
//	get one by subject
	public Tag getBySubject(String subject) {
		return tagRepo.findBySubjectIs(subject);
	}
	
//	create
	public Tag create(Tag tag) {
		return tagRepo.save(tag);
	}
	
}
