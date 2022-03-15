package com.codingdojo.corredor_de_libros.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.corredor_de_libros.models.Borrow;
import com.codingdojo.corredor_de_libros.repositories.BorrowRepository;

@Service
public class BorrowService {

	final BorrowRepository borrowRepository;
	
	public BorrowService(BorrowRepository borrowRepository) {
		this.borrowRepository = borrowRepository;
	}
	
	public List<Borrow> getBorrows() {
		return this.borrowRepository.findAll();
	}
	
	public Borrow addBorrow(Borrow borrow, BindingResult result) {
        if(result.hasErrors()) {
        	return null;
        }else {
        	return this.borrowRepository.save(borrow);        	
        }
	}
	
	public void deleteBorrowByBookId(Long id) {
        if(id != null) {
        	this.borrowRepository.delete_ByBookId(id);
        }
	}
}
