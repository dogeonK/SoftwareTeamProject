package com.cos.blog.service;

import com.cos.blog.model.News;
import com.cos.blog.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    @Transactional
    public Page<News> 글목록(Pageable pageable){
        return newsRepository.findAll(pageable);
    }
}
