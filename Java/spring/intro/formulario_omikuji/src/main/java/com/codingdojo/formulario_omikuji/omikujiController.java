package com.codingdojo.formulario_omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class omikujiController {
	
	@GetMapping("/omikuji")
	public String show_sendOmikuji(){
		return "sendOmikuji.jsp";
	}
	
	@PostMapping("/omikuji/process")
	public String omikujiProcess(
			HttpSession session, 
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city_name") String city_name,
			@RequestParam(value="person_name") String person_name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="living_thing") String living_thing,
			@RequestParam(value="something_nice") String something_nice) {
		
		session.setAttribute("number", number);
		session.setAttribute("city_name", city_name);
		session.setAttribute("person_name", person_name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living_thing", living_thing);
		session.setAttribute("something_nice", something_nice);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String show_showOmikuji(HttpSession session, Model model){
		
		model.addAttribute("number", session.getAttribute("number"));
		model.addAttribute("city_name", session.getAttribute("city_name"));
		model.addAttribute("person_name", session.getAttribute("person_name"));
		model.addAttribute("hobby", session.getAttribute("hobby"));
		model.addAttribute("living_thing", session.getAttribute("living_thing"));
		model.addAttribute("something_nice", session.getAttribute("something_nice"));
		
		return "showOmikuji.jsp";
	}
}