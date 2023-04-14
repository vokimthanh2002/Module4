package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.NhanVien;
import com.example.quanlythucung.bean.Shop;

import java.util.List;

public interface NhanVienService {
    void addNhanVien(NhanVien nhanVien);
    void updateNhanVien(NhanVien nhanVien);
    void deleteNhanVien(NhanVien nhanVien);
    NhanVien findByName(String tenNhanVien);
    List<NhanVien> getAllNhanVien();
    List<NhanVien> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
}
