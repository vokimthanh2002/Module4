package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.NhanVien;
import com.example.quanlythucung.bean.Shop;
import com.example.quanlythucung.repository.NhanVienRepository;
import com.example.quanlythucung.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepository repository;

    @Override
    public void addNhanVien(NhanVien nhanVien) {
        repository.save(nhanVien);
    }

    @Override
    public void updateNhanVien(NhanVien nhanVien) {
        repository.save(nhanVien);
    }

    @Override
    public void deleteNhanVien(NhanVien nhanVien) {
        repository.delete(nhanVien);
    }

    @Override
    public NhanVien findByName(String tenNhanVien) {
        return repository.findById(tenNhanVien).orElse(null);
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        return repository.findAll();
    }

    @Override
    public List<NhanVien> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap) {
        return repository.findByShop_ChuShop_TaiKhoan_TenDangNhap(tenDangNhap);
    }


}
