package com.example.blog.repository;

import com.example.blog.bean.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
}
