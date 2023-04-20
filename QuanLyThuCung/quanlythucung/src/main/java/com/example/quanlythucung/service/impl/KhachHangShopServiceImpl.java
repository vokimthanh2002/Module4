package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.KhachHangShop;
import com.example.quanlythucung.repository.KhachHangShopRepository;
import com.example.quanlythucung.service.KhacHangShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangShopServiceImpl implements KhacHangShopService {
    @Autowired
    KhachHangShopRepository repository;
    @Override
    public void save(KhachHangShop khachHangShop) {
        repository.save(khachHangShop);
    }
}
