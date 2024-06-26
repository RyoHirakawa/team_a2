package com.example.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.model.Notice;
import com.example.sample.repository.NoticeRepository;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    public void saveNotice(Notice notice) {
        noticeRepository.save(notice);
    }
    
    public void deleteNoticeById(Long id) {
        noticeRepository.deleteById(id);
    }
    
    public Optional<Notice> getNoticeById(Long id) {
        return noticeRepository.findById(id);
    }
}

