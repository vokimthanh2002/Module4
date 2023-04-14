package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.TaiKhoan;

import java.util.List;

public interface UserService {
    void addUser(TaiKhoan taiKhoan);
    void updateUser(TaiKhoan taiKhoan);
    void deleteUser(TaiKhoan taiKhoan);
    List<TaiKhoan> getAllUser();
    TaiKhoan finById(String tenTaiKhoan);
    TaiKhoan checkPass(String user);

}
