package com.codingdojo.club_del_libro.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.club_del_libro.models.Book;
import com.codingdojo.club_del_libro.models.User;
import com.codingdojo.club_del_libro.services.BookService;
import com.codingdojo.club_del_libro.services.UserService;

@Controller
public class BooksController {
	
	final UserService userService;
	final BookService bookService;
	
	public BooksController(UserService userService, BookService bookService) {
		this.userService = userService;
		this.bookService = bookService;
	}


	@GetMapping("/books")
	public String show_dashboard(
			Model model, 
			HttpSession session) {
		
		Long userId = (Long)session.getAttribute("userId");
		
		if( userId != null ) {
			model.addAttribute("user", this.userService.getUserById(userId));
			model.addAttribute("books", bookService.getBooks());
			return "books.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/books/new")
	public String show_newBookForm(
			Model model, 
			HttpSession session) {
		
		Long userId = (Long)session.getAttribute("userId");
		
		if( userId != null ) {
			User user = this.userService.getUserById(userId);
			Book book = new Book();
			
			model.addAttribute("user", user);
			model.addAttribute("book", book);
			
			return "newBook.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/books/new")
	public String newBook(
			Model model, 
			HttpSession session,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		
		Long userId = (Long)session.getAttribute("userId");
		
		if( userId != null ) {
			User user = this.userService.getUserById(userId);
			
			if ( this.bookService.addBook(book, result) != null ) {
				return "redirect:/books";				
			}else {
				model.addAttribute("user", user);
				return "newBook.jsp";
			}
		}else {
			return "redirect:/";
		}
	}
	

	
	@GetMapping("/books/{book_id}")
	public String show_book(
			Model model, 
			HttpSession session,
			@PathVariable("book_id") Long book_id) {
		
		Long userId = (Long)session.getAttribute("userId");
		
		if( userId != null ) {
			User user = this.userService.getUserById(userId);
			Book book = bookService.getBookById(book_id);
			Boolean isTheUser = user.getBooks().contains(book);
			
			model.addAttribute("user", user);
			model.addAttribute("book", book);
			model.addAttribute("isTheUser", isTheUser);
			
			return "showBook.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/books/{book_id}/edit")
	public String show_editBookForm(
			Model model, 
			HttpSession session,
			@PathVariable("book_id") Long book_id) {
		
		Long userId = (Long)session.getAttribute("userId");
		
		if( userId != null ) {
			User user = this.userService.getUserById(userId);
			Book book = bookService.getBookById(book_id);
			Boolean isTheUser = user.getBooks().contains(book);
			
			if ( isTheUser ) {
				model.addAttribute("user", user);
				model.addAttribute("book", book);
				
				return "editBook.jsp";				
			}else {
				return "redirect:/";
			}
		}else {
			return "redirect:/";
		}
	}
	
	@PutMapping("/books/{book_id}/edit")
	public String editBook(
			HttpSession session, 
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		
		Long userId = (Long)session.getAttribute("userId");
		
		if( userId != null ) {
			if( this.bookService.editBook(book, result) != null ) {				
				return "redirect:/books";
			}else {
				return "editBook.jsp";
			}

		}else {
			return "redirect:/";
		}

	}

}
