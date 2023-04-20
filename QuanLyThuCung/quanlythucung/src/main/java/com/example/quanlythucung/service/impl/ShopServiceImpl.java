package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.Shop;
import com.example.quanlythucung.repository.ShopRepository;
import com.example.quanlythucung.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopRepository repository;

    @Override
    public void addShop(Shop shop) {
        repository.save(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        repository.save(shop);
    }

    @Override
    public Shop findByName(String tenShop) {
        return repository.findById(tenShop).orElse(null);
    }

    @Override
    public Shop findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Shop> findAllShop() {
        return repository.findAll();
    }

    @Override
    public void deleteShop(Shop shop) {
        repository.delete(shop);
    }

    @Override
    public Shop findByChuShop_TaiKhoan_TenDangNhap(String tenDangNhap) {
        return repository.findByChuShop_TaiKhoan_TenDangNhap(tenDangNhap);
    }

    @Override
    public Shop findByIdDichVu(String idDichVu) {
        return repository.findByIdDichVu(idDichVu);
    }

    @Override
    public List<Shop> findByTrangThai(String trangThai) {
        return repository.findByTrangThai(trangThai);
    }


}
