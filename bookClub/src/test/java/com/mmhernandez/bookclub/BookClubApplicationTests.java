package com.mmhernandez.bookclub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mmhernandez.bookclub.controllers.BookController;
import com.mmhernandez.bookclub.models.Book;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
class BookClubApplicationTests {
	
	@Autowired
	private BookController bookController;
	
	private static Validator validator;
	
	@BeforeAll
	static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testBookController() {
		assertThat(bookController).isNotNull();
	}
	
	@Test
	void testBook() {
		Book book = new Book();
		book.setTitle("Harry Potter and the Goblet of Fire");
		book.setThoughts("Great book");
		book.setAuthor("J.K. Rowling");
		
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		for (ConstraintViolation<Book> violation : violations) {
            System.out.println(violation.getMessage()); 
        }
        assertTrue(violations.isEmpty());
	}

}
