package com.codingdojo.corredor_de_libros.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.corredor_de_libros.models.Borrow;
import com.codingdojo.corredor_de_libros.services.BorrowService;

@Controller
public class BorrowsController {
	
	final BorrowService borrowService;
	
	public BorrowsController(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	@PostMapping("/borrows/new")
	public String newBorrow(
			HttpSession session,
			@Valid @ModelAttribute("borrow") Borrow borrow,
			BindingResult result) {
		
		this.borrowService.addBorrow(borrow, result);
		return "redirect:/bookmarket";
	}
	
	@DeleteMapping("/borrows/delete")
	public String deleteBorrow(@RequestParam("book_id") Long book_id) {
		this.borrowService.deleteBorrowByBookId(book_id);
		return "redirect:/bookmarket";
	}

}
