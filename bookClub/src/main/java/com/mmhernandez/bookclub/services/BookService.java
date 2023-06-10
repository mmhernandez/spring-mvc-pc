package com.mmhernandez.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.bookclub.models.Book;
import com.mmhernandez.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	
//	get all
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
//	get one by id
	public Book getById(Long id) {
		Optional<Book> oBook = bookRepo.findById(id);
		if(oBook.isPresent()) {
			return oBook.get();
		}
		return null;
	}
	
//	create
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
//	update
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
//	delete by id
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
