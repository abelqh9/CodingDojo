package com.codingdojo.variables_ruta_daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class Controlador {
	
    @RequestMapping("")
    public String hola() {
        return "¡Welcome!";
    }
    
    @RequestMapping("/today")
    public String hola_today() {
    	return "¡Today you will find luck in all tour endeavors!";
    }
    
    @RequestMapping("/tomorrow")
    public String hola_tomorrow() {
    	return "¡Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
    
    @RequestMapping("/travel/{place}")
    public String travel(@PathVariable("place") String place) {
    	return "Congratulations! You will soon travel to " + place + "!";
    }
    
    @RequestMapping("/lotto/{number}")
    public String lotto(@PathVariable("number") int number) {
    	if ( number % 2 == 0 ) {
    		return "You will take a gran journey in the near future, but be wary of tempting offers";    		
    	}else {
    		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
    	}
    }

}
