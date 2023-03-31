package com.example.validate_form.repository;

import com.example.validate_form.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
}
