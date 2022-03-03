package com.codingdojo.api_libros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.api_libros.models.Book;
import com.codingdojo.api_libros.services.BookService;

@Controller
public class BookController {

    private final BookService bookService;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("/books/{id}")
    public String show_book(@PathVariable("id") Long id, Model model) {
    	System.out.println(id);
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
    	return "show.jsp";
    }
}
