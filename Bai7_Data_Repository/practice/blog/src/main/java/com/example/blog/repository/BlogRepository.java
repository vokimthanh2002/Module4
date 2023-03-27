package com.example.blog.repository;

import com.example.blog.bean.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    List<Blog> findByContentContains(String content);
    List<Blog> findByCategory_Id(Long id);
}
