package com.example.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sample.model.Notice;
import com.example.sample.service.NoticeService;

@Controller
public class IndexController {
	@Autowired 
	NoticeService noticeService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Notice> notices = noticeService.getAllNotices();
		model.addAttribute("notices", notices);
		return "home";
	}

//	@GetMapping("/meibo")
//	public String meibo() {
//		return "meibo";
//	}
	
//	@GetMapping("/share")
//	public String share() {
//		return "share";
//	}
	
	@GetMapping("/kekka")
	public String kekka() {
		return "kekka";
	}
	
	@GetMapping("/print")
    public String print() {
        return "print";
    }
	
//	@GetMapping("/renraku_add")
//	public String renrakuAdd() {
//		return "renraku_add";
//	}

}
