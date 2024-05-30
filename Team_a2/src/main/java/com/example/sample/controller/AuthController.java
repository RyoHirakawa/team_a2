package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sample.model.User;
import com.example.sample.service.LoginUserDetailService;

@Controller
public class AuthController {
	
	@Autowired
    private LoginUserDetailService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		 model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(User user) {
		  userService.save(user);
	      return "redirect:/login";
	}
}
