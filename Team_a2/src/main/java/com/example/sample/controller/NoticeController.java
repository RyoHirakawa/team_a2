package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sample.model.Notice;
import com.example.sample.service.NoticeService;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/Notice")
    public String viewHomePage(Model model) {
        model.addAttribute("allNotices", noticeService.getAllNotices());
        return "notice";
    }

    @GetMapping("/addNotice")
    public String showAddNoticeForm(Model model) {
        model.addAttribute("notice", new Notice());
        return "add_notice";
    }

    @PostMapping("/saveNotice")
    public String saveNotice(@ModelAttribute("notice") Notice notice) {
        noticeService.saveNotice(notice);
        return "redirect:/";
    }
}
