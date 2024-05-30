package com.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "home";
	}

	@GetMapping("/meibo")
	public String meibo() {
		return "meibo";
	}
	
	@GetMapping("/share")
	public String share() {
		return "share";
	}
	
	@GetMapping("/kekka")
	public String kekka() {
		return "kekka";
	}
	
	@GetMapping("/print")
    public String print() {
        return "print";
    }
	
	@GetMapping("/renraku_add")
	public String renrakuAdd() {
		return "renraku_add";
	}

}
