package com.example.validate_form.service;

import com.example.validate_form.bean.User;
import com.example.validate_form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository serviceRepository;
    @Override
    public void save(User user) {
        serviceRepository.save(user);
    }
}
