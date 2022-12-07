package com.cos.blog.controller;

import com.cos.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping({"/notice"})
    public String index(Model model, @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", noticeService.글목록(pageable));
        return "noticeIndex"; // viewResolver 작동!!
    }

    @GetMapping("/notice/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("board", noticeService.글상세보기(id));

        return "notice/noticeDetail";
    }

    @GetMapping("/notice/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("board", noticeService.글상세보기(id));
        return "notice/noticeUpdate";
    }

    // USER 권한이 필요
    @GetMapping("/notice/saveForm")
    public String saveForm() {
        return "notice/noticeSaveForm";
    }
}
