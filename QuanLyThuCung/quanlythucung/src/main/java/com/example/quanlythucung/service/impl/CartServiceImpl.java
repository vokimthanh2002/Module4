package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.Cart;
import com.example.quanlythucung.repository.CartRepository;
import com.example.quanlythucung.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart findBySanPham_IdSanPham(String idSanPham, List<Cart> cartList) {
        Cart newCart = new Cart();
        for(Cart cart: cartList){
            if(cart.getSanPham().getIdSanPham().equals(idSanPham)){
                newCart =cart;
                break;
            }
        }
        return newCart;
    }

    @Override
    public int index(String idSanPham, List<Cart> cartList) {
        int index=0;
        for(int i=0; i<cartList.size();i++){
            if(cartList.get(i).getSanPham().getIdSanPham().equals(idSanPham)){
                index =i;
                break;
            }
        }
        return index;
    }
}
