package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.KhachHang;
import com.example.quanlythucung.repository.KhachHangRepository;
import com.example.quanlythucung.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
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


}
