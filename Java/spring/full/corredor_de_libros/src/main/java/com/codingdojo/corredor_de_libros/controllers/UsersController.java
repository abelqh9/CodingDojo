package com.codingdojo.corredor_de_libros.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.corredor_de_libros.models.LoginUser;
import com.codingdojo.corredor_de_libros.models.User;
import com.codingdojo.corredor_de_libros.services.UserService;

@Controller
public class UsersController {
	
	final UserService userService;
	
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String show_registerAndLogin(
			Model model, 
			HttpSession session) {
		
		if( session.getAttribute("userId") == null ) {
			
			model.addAttribute("user", new User());
			model.addAttribute("loginUser", new LoginUser());
			
			return "registerAndLogin.jsp";
		}else {
			return "redirect:/bookmarket";
		}
	}
	
	@PostMapping("/register")
	public String registerUser(
			Model model,
			@Valid @ModelAttribute("user") User user, 
			BindingResult result,
			HttpSession session) {
		
		User registerResult = this.userService.register(user, result);
		
		
		if( registerResult == null ) {
			model.addAttribute("loginUser", new LoginUser());
			return "registerAndLogin.jsp";
		}else {
			session.setAttribute("userId", registerResult.getId());
			return "redirect:/bookmarket";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(
			Model model,
			@Valid @ModelAttribute("loginUser") LoginUser loginUser, 
			BindingResult result,
			HttpSession session) {
		
		User loginResult = this.userService.login(loginUser, result);
		
		if( loginResult == null ) {
			model.addAttribute("user", new User());
			return "registerAndLogin.jsp";
		}else {
			session.setAttribute("userId", loginResult.getId());
			return "redirect:/bookmarket";
			
		}
	}
	
	@PostMapping("/logout")
	public String logoutUser(
			HttpSession session) {
		session.removeAttribute("userId");
			return "redirect:/";
	}
}
