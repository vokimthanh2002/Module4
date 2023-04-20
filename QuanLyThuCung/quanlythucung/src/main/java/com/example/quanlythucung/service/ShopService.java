package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.Shop;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopService {
    void addShop(Shop shop);
    void updateShop(Shop shop);
    Shop findByName(String tenShop);
    Shop findById(String id);
    List<Shop> findAllShop();
    void deleteShop(Shop shop);
    Shop findByChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
    Shop findByIdDichVu(String idDichVu);
    List<Shop> findByTrangThai(String trangThai);
}
