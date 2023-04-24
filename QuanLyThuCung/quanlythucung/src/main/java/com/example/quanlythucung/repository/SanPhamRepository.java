package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.DichVu;
import com.example.quanlythucung.bean.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham,String> {
    List<SanPham> findByTenSanPhamContains(String tenSanPham);
    List<SanPham> findByDanhMuc_IdDanhMuc(String idDanhMuc);
    List<SanPham> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
    List<SanPham> findByTenSanPhamContainsOrMoTaContains(String tenSanPham,String moTa);
}
