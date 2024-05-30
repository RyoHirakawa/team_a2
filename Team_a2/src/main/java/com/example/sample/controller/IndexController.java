package com.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String getindex() {
		return "home";
	}
	@GetMapping("/meibo")
	public String getmeibo() {
		return "meibo";
	}
	@GetMapping("/share")
	public String getshare() {
		return "share";
	}
	@GetMapping("/kekka")
	public String getkekka() {
		return "kekka";
	}
	@GetMapping("/print")
	public String getprint() {
		return "print";
	}
	
	
	

}