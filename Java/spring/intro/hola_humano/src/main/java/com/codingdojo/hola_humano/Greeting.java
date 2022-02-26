package com.codingdojo.hola_humano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	
	@RequestMapping("/")
	public String greeting(@RequestParam(value="name", required=false) String name, @RequestParam(value="last_name", required=false) String last_name) {
		String stringToReturn = "Hello ";
		if(name == null) {
			stringToReturn += "Human";
		}else if (last_name == null) {
			stringToReturn += name;
		}else {
			stringToReturn += (name + " " + last_name);
		}
		return stringToReturn;
	}
}
