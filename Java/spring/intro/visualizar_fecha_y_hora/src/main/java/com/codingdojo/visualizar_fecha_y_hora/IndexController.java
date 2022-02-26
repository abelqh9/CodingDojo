package com.codingdojo.visualizar_fecha_y_hora;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		Date dateToSend = new Date();
		model.addAttribute("date", dateToSend);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		Date dateToSend = new Date();
		model.addAttribute("date", dateToSend);
		return "time.jsp";
	}

}
