package com.codingdojo.dojos_y_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojos_y_ninjas.models.Dojo;
import com.codingdojo.dojos_y_ninjas.services.DojoService;

@Controller
public class DojosController {
	
	final DojoService dojoService;
	
	public DojosController(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	@GetMapping("/dojos/new")
	public String ShowNewDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "newDojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		System.out.println(33333333);
		if( result.hasErrors() ) {
			return "newDojo.jsp";	
		}else {
			Dojo newDojo = this.dojoService.createDojo(dojo);
			return "redirect:/dojos/"+newDojo.getId();
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String ShowDojosNew(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.dojoService.getDojo(id));
		return "showDojo.jsp";
	}
}
