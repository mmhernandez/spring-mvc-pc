package com.mmhernandez.paginationsorting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mmhernandez.paginationsorting.models.Dojo;
import com.mmhernandez.paginationsorting.repositories.DojoPagingRepository;
import com.mmhernandez.paginationsorting.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	DojoPagingRepository dojoPagingRepo;
	
	
//	create dojo
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	get all dojos and ninjas - pageable
	private static final int PAGE_SIZE = 5;
	public Page<Dojo> getAllDojosAndNinjasPageable(int pageNumber) {
		PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "name");
		return dojoPagingRepo.findAll(pageRequest);
	}
	
//	get all dojos
	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}
}
