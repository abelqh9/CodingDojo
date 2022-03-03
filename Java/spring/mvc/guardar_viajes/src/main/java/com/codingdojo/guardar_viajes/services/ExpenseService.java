package com.codingdojo.guardar_viajes.services;

import java.util.List;

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
    
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
}