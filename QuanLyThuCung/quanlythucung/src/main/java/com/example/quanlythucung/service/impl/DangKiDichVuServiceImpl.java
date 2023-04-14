package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.DangKiDichVu;
import com.example.quanlythucung.bean.KhachHang;
import com.example.quanlythucung.repository.DangKiDichVuRepository;
import com.example.quanlythucung.service.DangKiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangKiDichVuServiceImpl implements DangKiDichVuService {
    @Autowired
    DangKiDichVuRepository repository;
    @Override
    public void addDangKiDichVu(DangKiDichVu dangKiDichVu) {
        repository.save(dangKiDichVu);
    }

    @Override
    public void updateDangKiDichVu(DangKiDichVu dangKiDichVu) {
        repository.save(dangKiDichVu);
    }

    @Override
    public void deleteDangDangDichVu(DangKiDichVu dangKiDichVu) {
        repository.delete(dangKiDichVu);
    }

    @Override
    public List<DangKiDichVu> findAllDangKiDichVu() {
        return repository.findAll();
    }

    @Override
    public DangKiDichVu finByNameKhachHang(KhachHang khachHang) {
        return repository.findByKhachHang(khachHang);
    }

    @Override
    public List<DangKiDichVu> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap) {
        return repository.findByShop_ChuShop_TaiKhoan_TenDangNhap(tenDangNhap);
    }
}
