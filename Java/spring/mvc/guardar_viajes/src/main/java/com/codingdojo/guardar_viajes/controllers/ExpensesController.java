package com.codingdojo.guardar_viajes.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.guardar_viajes.models.Expense;
import com.codingdojo.guardar_viajes.services.ExpenseService;

@Controller
public class ExpensesController {
    private final ExpenseService expenseService;
    
    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

	@GetMapping("/expenses")
	public String show_expenses(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "expenses.jsp";
	}
	
	@PostMapping("/add_expense")
	public String add_expense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (!result.hasErrors()) {
        	expenseService.createExpense(expense);
        	return "redirect:/expenses";
        }else {
    		model.addAttribute("expenses", expenseService.allExpenses());
        	return "expenses.jsp";
        }
	}
}
