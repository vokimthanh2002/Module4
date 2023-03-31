package com.example.validate_form.service;

import com.example.validate_form.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserService  {
    void save(User user);
}
