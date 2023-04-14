package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.NhanVien;
import com.example.quanlythucung.bean.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien,String> {
    List<NhanVien> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
}