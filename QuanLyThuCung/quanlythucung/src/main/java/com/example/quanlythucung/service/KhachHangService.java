package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> findAllKhachHang();
    List<KhachHang> findByListKhachHang(String tenDangNhap);

    void save(KhachHang khachHang);

    KhachHang findByTaiKhoan_TenDangNhap(String tenDangNhap);
}
