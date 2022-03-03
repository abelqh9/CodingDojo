package com.codingdojo.guardar_viajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.guardar_viajes.models.Expense;
import com.codingdojo.guardar_viajes.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    
    public Expense createExpense(Expense e) {
        return expenseRepository.save(e);
    }
    
    public Expense findExpense(Long id) {
    	Optional<Expense> optionalExpense = expenseRepository.findById(id);
    	if(optionalExpense.isPresent()) {
    		return optionalExpense.get();
    	} else {
    		return null;
    	}
    }
    
    public Expense updateExpense(Expense expenseWithNewData) {
        return expenseRepository.save(expenseWithNewData);
    }
    
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    
}