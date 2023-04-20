package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    void delete(Integer id);
    void save(Cart cart);
    Cart findById(Integer id);
    Cart findBySanPham_IdSanPham(String idSanPham, List<Cart> cartList);
    int index(String idSanPham, List<Cart> cartList);
}
