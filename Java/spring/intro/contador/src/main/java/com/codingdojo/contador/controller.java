package com.codingdojo.contador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

	@RequestMapping("/")
	public String showIndex(HttpSession session){
		
		Object countOfSession = session.getAttribute("count");
		
		if (countOfSession == null) {
			session.setAttribute("count", 1);
		}
		else {
			session.setAttribute("count", ((int)countOfSession)+1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String showCounter(HttpSession session, Model model){
		
		Object countOfSession = session.getAttribute("count");
		
		if (countOfSession == null) {
			session.setAttribute("count", 0);
			model.addAttribute("times", 0);
		}else {
			model.addAttribute("times", countOfSession);
		}
		
		return "counter.jsp";
	}
}
