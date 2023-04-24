package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.SanPham;
import com.example.quanlythucung.repository.SanPhamRepository;
import com.example.quanlythucung.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository repository;

    @Override
    public void addSanPham(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public List<SanPham> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<SanPham> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deteteSanPham(SanPham sanPham) {
        repository.delete(sanPham);
    }

    @Override
    public SanPham finById(String idSanPham) {
        return repository.findById(idSanPham).orElse(null);
    }

    @Override
    public List<SanPham> findByTenSanPhamContains(String tenSanPham) {
        return repository.findByTenSanPhamContains(tenSanPham);
    }

    @Override
    public List<SanPham> findByDanhMuc_IdDanhMuc(String idDanhMuc) {
        return repository.findByDanhMuc_IdDanhMuc(idDanhMuc);
    }

    @Override
    public List<SanPham> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap) {
        return repository.findByShop_ChuShop_TaiKhoan_TenDangNhap(tenDangNhap);
    }

    @Override
    public List<SanPham> findAllContains(String tenSanPham, String moTa) {
        return repository.findByTenSanPhamContainsOrMoTaContains(tenSanPham,moTa);
    }
}
