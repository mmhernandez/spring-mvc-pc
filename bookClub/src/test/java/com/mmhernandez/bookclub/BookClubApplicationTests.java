package com.mmhernandez.bookclub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mmhernandez.bookclub.controllers.BookController;
import com.mmhernandez.bookclub.controllers.UserController;
import com.mmhernandez.bookclub.models.Book;
import com.mmhernandez.bookclub.models.User;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
class BookClubApplicationTests {
	
	@Autowired
	private BookController bookController;
	
	@Autowired
	private UserController userController;
	
	private static Validator validator;
	
	@BeforeAll
	static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	
	@Test
	void contextLoads() {
	}
	
	
//	book model tests	
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
	
	
//	user model tests
	@Test
	void testUserController() {
		assertThat(userController).isNotNull();
	}
	
	@Test
	void testUser() {
		User user = new User();
		user.setName("Melissa");
		user.setEmail("melissa@email.com");
		user.setPassword("passwordTest");
		user.setConfirmPassword("passwordTest");
		
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		for(ConstraintViolation<User> violation : violations) {
			System.out.println(violation.getMessage());
		}
		assertTrue(violations.isEmpty());
	}
	
}
