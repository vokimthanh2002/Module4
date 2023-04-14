package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.DangKiDichVu;
import com.example.quanlythucung.bean.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DangKiDichVuRepository extends JpaRepository<DangKiDichVu,String> {
    DangKiDichVu findByKhachHang(KhachHang khachHang);
    List<DangKiDichVu> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
}
