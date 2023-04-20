package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findBySanPham_IdSanPham(String idSanPham);
}
