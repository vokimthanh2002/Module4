package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.Shop;

import java.util.List;

public interface ShopService {
    void addShop(Shop shop);
    void updateShop(Shop shop);
    Shop findByName(String tenShop);
    List<Shop> findAllShop();
    void deleteShop(Shop shop);
    Shop findByChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
}
