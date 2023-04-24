package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SanPhamService {
    void addSanPham(SanPham sanPham);
    void updateSanPham(SanPham sanPham);
    List<SanPham> findAll();
    Page<SanPham> findAll(Pageable pageable);
    void deteteSanPham(SanPham sanPham);
    SanPham finById(String idSanPham);
    List<SanPham> findByTenSanPhamContains(String tenSanPham);
    List<SanPham> findByDanhMuc_IdDanhMuc(String idDanhMuc);
    List<SanPham> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
    List<SanPham> findAllContains(String tenSanPham,String moTa);
}
