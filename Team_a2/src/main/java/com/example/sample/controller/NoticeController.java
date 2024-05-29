package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sample.model.Notice;
import com.example.sample.service.NoticeService;

@Controller
@RequestMapping("/Notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("")
    public String viewHomePage(Model model) {
        model.addAttribute("allNotices", noticeService.getAllNotices());
        return "notice";
    }

    @GetMapping("/add")
    public String showAddNoticeForm(Model model) {
        model.addAttribute("notice", new Notice());
        return "add_notice";
    }

    @PostMapping("/save")
    public String saveNotice(@ModelAttribute("notice") Notice notice) {
        noticeService.saveNotice(notice);
        return "redirect:/Notice";
    }
}
