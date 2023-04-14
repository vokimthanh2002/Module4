package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.DangKiDichVu;
import com.example.quanlythucung.bean.KhachHang;

import java.util.List;

public interface DangKiDichVuService {
    void addDangKiDichVu(DangKiDichVu dangKiDichVu);
    void updateDangKiDichVu(DangKiDichVu dangKiDichVu);
    void deleteDangDangDichVu(DangKiDichVu dangKiDichVu);
    List<DangKiDichVu> findAllDangKiDichVu();
    DangKiDichVu finByNameKhachHang(KhachHang khachHang);
    List<DangKiDichVu> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
}
