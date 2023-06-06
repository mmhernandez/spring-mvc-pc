package com.mmhernandez.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.studentroster.models.Dorm;
import com.mmhernandez.studentroster.repositories.DormRepository;

@Service
public class DormService {

	@Autowired
	DormRepository dormRepository;
	
//	create
	public Dorm createDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
//	get all
	public List<Dorm> getAll() {
		return dormRepository.findAll();
	}
	
//	get one by id
	public Dorm getById(Long id) {
		Optional<Dorm> optDorm = dormRepository.findById(id);
		if(optDorm.isPresent()) {
			return optDorm.get();
		}
		return null;
	}
	
//	get dorm count
	public Long count() {
		return dormRepository.count();
	}
}
