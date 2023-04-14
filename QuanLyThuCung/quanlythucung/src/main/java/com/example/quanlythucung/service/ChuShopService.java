package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.ChuShop;
import com.example.quanlythucung.bean.Shop;

import java.util.List;

public interface ChuShopService {
    void addChuShop(ChuShop chuShop);
    void updateChuShop(ChuShop chuShop);
    ChuShop finById(String maChuShop);
    void deleteChuShop(ChuShop chuShop);
    List<ChuShop> findAllChuShop();

}
