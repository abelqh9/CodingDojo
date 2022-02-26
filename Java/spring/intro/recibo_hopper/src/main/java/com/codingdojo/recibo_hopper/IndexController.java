package com.codingdojo.recibo_hopper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		String customer_name = "Grace Hopper";
		String item_name = "Copper Wire";
		String item_price = "5.25";
		String item_description = "Metal strips. Also an illustration of nanoseconds";
		String item_vendor = "Little Things Corner Store";
		
		model.addAttribute("customer_name", customer_name);
		model.addAttribute("item_name", item_name);
		model.addAttribute("item_price", item_price);
		model.addAttribute("item_description", item_description);
		model.addAttribute("item_vendor", item_vendor);
		
		return "index.jsp";
	}
}
