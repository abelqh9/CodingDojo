package com.codingdojo.inicio_de_sesion_y_registro.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.inicio_de_sesion_y_registro.models.LoginUser;
import com.codingdojo.inicio_de_sesion_y_registro.models.User;
import com.codingdojo.inicio_de_sesion_y_registro.services.UserService;

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
			return "redirect:/dashboard";
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
			return "redirect:/dashboard";
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
			return "redirect:/dashboard";
			
		}
	}
	
	@GetMapping("/dashboard")
	public String show_dashboard(
			Model model, 
			HttpSession session) {
		
		Long userId = (Long)session.getAttribute("userId");
		
		if( userId != null ) {
			model.addAttribute("user", this.userService.getUserById(userId));
			return "dashboard.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	
	@PostMapping("/logout")
	public String logoutUser(
			HttpSession session) {
		session.removeAttribute("userId");
			return "redirect:/";
	}
}
