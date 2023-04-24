package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.ChuShop;
import com.example.quanlythucung.bean.Shop;
import com.example.quanlythucung.repository.ChuShopRepository;
import com.example.quanlythucung.service.ChuShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuShopServiceImpl implements ChuShopService {
    @Autowired
    ChuShopRepository repository;

    @Override
    public void addChuShop(ChuShop chuShop) {
        repository.save(chuShop);
    }

    @Override
    public void updateChuShop(ChuShop chuShop) {
        repository.save(chuShop);
    }

    @Override
    public ChuShop finById(String maChuShop) {
        return repository.findById(maChuShop).orElse(null);
    }

    @Override
    public void deleteChuShop(ChuShop chuShop) {
        repository.delete(chuShop);
    }

    @Override
    public List<ChuShop> findAllChuShop() {
        return repository.findAll();
    }

    @Override
    public List<ChuShop> findByTrangThai(String trangThai) {
        return repository.findByTrangThai(trangThai);
    }

    @Override
    public ChuShop finBYChuShop_IdDichVu(String idDichVu) {
        return repository.finBYChuShop_IdDichVu(idDichVu);
    }

    @Override
    public ChuShop finBYChuShop_IdSanPham(String idSanPham) {
        return repository.finBYChuShop_IdSanPham(idSanPham);
    }

    @Override
    public ChuShop findByIdShop(String idShop) {
        return repository.findByIdShop(idShop);
    }


}
