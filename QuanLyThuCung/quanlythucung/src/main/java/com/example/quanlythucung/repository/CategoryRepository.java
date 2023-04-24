package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
