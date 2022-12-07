package com.cos.blog.controller;

import com.cos.blog.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    public String newList(Model model, @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boards", newsService.글목록(pageable));
        return "newsIndex";
    }

}
