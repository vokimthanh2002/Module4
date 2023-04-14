package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TaiKhoan,String> {
    public TaiKhoan findByTenDangNhap(String tenDangNhap);
}
