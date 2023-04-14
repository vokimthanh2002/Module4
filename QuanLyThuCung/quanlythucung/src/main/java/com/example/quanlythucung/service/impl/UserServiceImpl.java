package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.TaiKhoan;
import com.example.quanlythucung.repository.UserRepository;
import com.example.quanlythucung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;
    @Override
    public void addUser(TaiKhoan taiKhoan) {
        repository.save(taiKhoan);
    }

    @Override
    public void updateUser(TaiKhoan taiKhoan) {
        repository.save(taiKhoan);
    }

    @Override
    public void deleteUser(TaiKhoan taiKhoan) {
        repository.delete(taiKhoan);
    }

    @Override
    public List<TaiKhoan> getAllUser() {
        return repository.findAll();
    }

    @Override
    public TaiKhoan finById(String tenTaiKhoan) {
        return repository.findById(tenTaiKhoan).orElse(null);
    }

    @Override
    public TaiKhoan checkPass(String user) {
        return repository.findByTenDangNhap(user);
    }
}
