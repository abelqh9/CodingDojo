package com.codingdojo.api_libros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.api_libros.services.BookService;

@Controller
public class BookController {

    private final BookService bookService;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("/books")
    public String show_book(Model model) {
        model.addAttribute("books", bookService.allBooks());
    	return "books.jsp";
    }
    
    @GetMapping("/books/{id}")
    public String show_book(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findBook(id));
    	return "book.jsp";
    }
}
