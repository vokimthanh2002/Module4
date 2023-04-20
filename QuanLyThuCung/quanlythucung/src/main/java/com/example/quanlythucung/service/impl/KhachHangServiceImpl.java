package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.KhachHang;
import com.example.quanlythucung.repository.KhachHangRepository;
import com.example.quanlythucung.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository  repository;

    @Override
    public List<KhachHang> findAllKhachHang() {
        return repository.findAll();
    }

    @Override
    public List<KhachHang> findByListKhachHang(String tenDangNhap) {
        return repository.findByListKhachHang(tenDangNhap);
    }

    @Override
    public void save(KhachHang khachHang) {
        repository.save(khachHang);
    }

    @Override
    public KhachHang findByTaiKhoan_TenDangNhap(String tenDangNhap) {
        return repository.findByTaiKhoan_TenDangNhap(tenDangNhap);
    }


}
