package com.codingdojo.guardar_viajes.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.guardar_viajes.models.Expense;
import com.codingdojo.guardar_viajes.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {
    private final ExpenseService expenseService;
    
    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

	@GetMapping("")
	public String show_expenses(Model model) {
		model.addAttribute("expenses", expenseService.allExpenses());
		model.addAttribute("expense", new Expense());
		return "expenses.jsp";
	}
	
	@PostMapping("")
	public String add_expense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (!result.hasErrors()) {
        	expenseService.createExpense(expense);
        	return "redirect:/expenses";
        }else {
    		model.addAttribute("expenses", expenseService.allExpenses());
        	return "expenses.jsp";
        }
	}
	
	@GetMapping("/edit/{id}")
	public String show_edit_expense(
			@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("expense", expenseService.findExpense(id));
        return "edit_expense.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String edit_expense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (!result.hasErrors()) {
        	expenseService.updateExpense(expense);
        	return "redirect:/expenses";
        }else {
        	return "edit_expense.jsp";
        }
	}
}
