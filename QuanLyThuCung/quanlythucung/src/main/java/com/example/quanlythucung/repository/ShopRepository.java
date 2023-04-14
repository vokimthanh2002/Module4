package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,String> {
    Shop findByChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
}
