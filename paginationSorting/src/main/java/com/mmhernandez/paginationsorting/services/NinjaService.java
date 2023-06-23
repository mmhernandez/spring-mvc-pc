package com.mmhernandez.paginationsorting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.paginationsorting.models.Ninja;
import com.mmhernandez.paginationsorting.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	NinjaRepository ninjaRepo;
	
	
//	create ninja
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
}
