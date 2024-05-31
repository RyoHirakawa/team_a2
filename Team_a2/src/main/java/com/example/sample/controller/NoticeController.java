package com.example.sample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sample.service.NoticeService;
import com.mysql.cj.protocol.x.Notice;

@Controller
@RequestMapping("/Notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("")
	public String viewHomePage(Model model) {
		System.out.println(noticeService.getAllNotices());
		model.addAttribute("allNotices", noticeService.getAllNotices());
		return "Notice";
	}

	@GetMapping("/add")
	public String showAddNoticeForm(Model model) {
		model.addAttribute("notice", new Notice());
		return "renraku_add";
	}

	@PostMapping("/save")
	public String saveNotice(@ModelAttribute("notice") Notice notice) {
		noticeService.saveNotice(notice);
		return "redirect:/Notice";
	}

	@GetMapping("/delete/{id}")
	public String deleteNotice(@PathVariable("id") Long id) {
		noticeService.deleteNoticeById(id);
		return "redirect:/Notice";
	}

	@GetMapping("/edit/{id}")
	public String showEditNoticeForm(@PathVariable("id") Long id, Model model) {
		Optional<Notice> notice = noticeService.getNoticeById(id);
		if (notice.isPresent()) {
			model.addAttribute("notice", notice.get());
			return "edit_notice";
		} else {
			return "redirect:/Notice";
		}
	}

	@PostMapping("/update/{id}")
	public String updateNotice(@PathVariable("id") Long id, @ModelAttribute("notice") Notice notice) {
		Notice existingNotice = noticeService.getNoticeById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid notice Id:" + id));
		existingNotice.setTitle(notice.getTitle());
		existingNotice.setContent(notice.getContent());
		noticeService.saveNotice(existingNotice);
		return "redirect:/Notice";
	}
}