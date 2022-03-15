package com.codingdojo.club_del_libro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.club_del_libro.models.Book;
import com.codingdojo.club_del_libro.repositories.BookRepository;

@Service
public class BookService {

	final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getBooks() {
		return this.bookRepository.findAll();
	}
	
	public Book getBookById(Long id) {
		Optional<Book> result = this.bookRepository.findById(id);
		
		if( result.isPresent() ){
			return result.get();
		}else {
			return null;
		}
	}
	
	public Book addBook(Book book, BindingResult result) {
        if(result.hasErrors()) {
        	return null;
        }else {
        	return this.bookRepository.save(book);        	
        }
	}
	
	public Book editBook(Book book, BindingResult result) {
        if(result.hasErrors()) {
        	return null;
        }else {
        	return this.bookRepository.save(book);        	
        }
	}
}
