package com.codingdojo.juego_oro_ninja;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {

	@GetMapping("/")
	public String show_index(Model model, HttpSession session) {
		
		if (session.getAttribute("ninja_gold") == null) {
			session.setAttribute("ninja_gold", 0);
			session.setAttribute("activities_texts", new ArrayList<ArrayList<Object>>());
			
			model.addAttribute("ninja_gold", 0);
			model.addAttribute("activities_texts", new ArrayList<ArrayList<Object>>());
		}else {
			model.addAttribute("ninja_gold", session.getAttribute("ninja_gold"));
			model.addAttribute("activities_texts",  session.getAttribute("activities_texts"));
		}
		
		return "index.jsp";
	}
	
	public ArrayList<Object> returnGoodText(int amount, String building) {
		Date date = new Date();
		ArrayList<Object> new_text = new ArrayList<Object>(Arrays.asList(true, " Earned " + amount + " golds from the " + building + "! " + date));
		return new_text;
	}
	
	public ArrayList<Object> returnBadText(int amount, String building) {
		Date date = new Date();
		ArrayList<Object> new_text = new ArrayList<Object>(Arrays.asList(false, " Entered a casino and lost " + amount + " golds... Ouch.. " + date));
		return new_text;
	}
	
	@PostMapping("/process_money")
	public String process_index(HttpSession session, @RequestParam(value="building") String building) {
		
		Integer ninja_gold = (Integer)session.getAttribute("ninja_gold");
		ArrayList<ArrayList<Object>> activities_texts = (ArrayList<ArrayList<Object>>) session.getAttribute("activities_texts");

	    if (building.equals("farm")) {
	    	Random r = new Random();
	    	Integer amount = r.nextInt(21-10)+10;
	    	ninja_gold += amount;
	    	activities_texts.add(returnGoodText(amount, building));
	    }else if(building.equals("cave")) {
	    	Random r = new Random();
	    	Integer amount = r.nextInt(11-5)+5;
	    	ninja_gold += amount;
	    	activities_texts.add(returnGoodText(amount, building));
	    }else if(building.equals("house")) {
	    	Random r = new Random();
	    	Integer amount = r.nextInt(6-2)+2;
	    	ninja_gold += amount;
	    	activities_texts.add(returnGoodText(amount, building));
	    }else if(building.equals("casino")) {
	    	Random r = new Random();
	    	Integer amount = r.nextInt(51);
	    	Integer destiny = r.nextInt(2);
	    	if ( destiny == 1 ) {
	    		ninja_gold += amount;	    		
	    		activities_texts.add(returnGoodText(amount, building));
	    	}else {
	    		ninja_gold -= amount;
	    		activities_texts.add(returnBadText(amount, building));
	    	}
	    }
	    
		session.setAttribute("ninja_gold", ninja_gold);
		session.setAttribute("activities_texts", activities_texts);
		
		return "redirect:/";
	}
}