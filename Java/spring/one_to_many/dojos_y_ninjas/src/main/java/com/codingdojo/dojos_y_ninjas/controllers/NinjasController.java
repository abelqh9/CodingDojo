package com.codingdojo.dojos_y_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojos_y_ninjas.models.Ninja;
import com.codingdojo.dojos_y_ninjas.services.DojoService;
import com.codingdojo.dojos_y_ninjas.services.NinjaService;

@Controller
public class NinjasController {

	final NinjaService ninjaService;
	final DojoService dojoService;
	
	public NinjasController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/ninjas/new")
	public String ShowNewNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojos", dojoService.getAllDojos());
		return "newNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String createNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if( result.hasErrors() ) {
			return "newNinja.jsp";			
		}else {
			Ninja newNinja = this.ninjaService.createNinja(ninja);
			return "redirect:/dojos/"+newNinja.getDojo().getId();
		}
	}
}
