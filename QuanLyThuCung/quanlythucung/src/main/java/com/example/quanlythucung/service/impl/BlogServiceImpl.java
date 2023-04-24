package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.Blog;
import com.example.quanlythucung.repository.BlogRepository;
import com.example.quanlythucung.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByContent(String content) {
        return blogRepository.findByContentContains(content);
    }

    @Override
    public List<Blog> findByCategory_Id(Long id) {
        return blogRepository.findByCategory_Id(id);
    }
}
