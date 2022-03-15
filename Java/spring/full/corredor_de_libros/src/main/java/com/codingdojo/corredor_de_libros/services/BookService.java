package com.codingdojo.corredor_de_libros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.corredor_de_libros.models.Book;
import com.codingdojo.corredor_de_libros.repositories.BookRepository;

@Service
public class BookService {

	final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getBooks() {
		return this.bookRepository.findAll();
	}
	
	public List<Book> getBooksToBorrow() {
		return this.bookRepository.find_AllBooksToBorrow();
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
	
	public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
	}
}
