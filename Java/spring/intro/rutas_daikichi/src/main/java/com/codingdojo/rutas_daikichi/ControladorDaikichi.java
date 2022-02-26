package com.codingdojo.rutas_daikichi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dakichi")
public class ControladorDaikichi {
	
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

}
