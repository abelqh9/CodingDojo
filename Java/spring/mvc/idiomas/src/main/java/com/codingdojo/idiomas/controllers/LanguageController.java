package com.codingdojo.idiomas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.idiomas.models.Language;
import com.codingdojo.idiomas.services.LanguageService;


@Controller
@RequestMapping("/languages")
public class LanguageController {
	
	
    private final LanguageService languageService;
    public LanguageController(LanguageService expenseService) {
        this.languageService = expenseService;
    }

    
	@GetMapping("")
	public String show_expenses(Model model) {
		model.addAttribute("languages", languageService.allLanguages());
		model.addAttribute("language", new Language());
		return "languages.jsp";
	}
	@PostMapping("")
	public String add_language(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (!result.hasErrors()) {
        	languageService.createLanguage(language);
        	return "redirect:/languages";
        }else {
    		model.addAttribute("languages", languageService.allLanguages());
        	return "languages.jsp";
        }
	}
	
	@GetMapping("/{id}")
	public String show_language(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
        return "show_language.jsp";
	}
	
	
	@GetMapping("/edit/{id}")
	public String show_edit_language(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
        return "edit_language.jsp";
	}
	@PutMapping("/edit/{id}")
	public String edit_language(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (!result.hasErrors()) {
        	languageService.updateLanguage(language);
        	return "redirect:/languages";
        }else {
        	return "edit_language.jsp";
        }
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delte_language(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
        return "redirect:/languages";
	}
}
