package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.ChuShop;
import com.example.quanlythucung.bean.Shop;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChuShopService {
    void addChuShop(ChuShop chuShop);
    void updateChuShop(ChuShop chuShop);
    ChuShop finById(String maChuShop);
    void deleteChuShop(ChuShop chuShop);
    List<ChuShop> findAllChuShop();
    List<ChuShop> findByTrangThai(String trangThai);
    ChuShop finBYChuShop_IdDichVu(@Param("idDichVu") String idDichVu);
    ChuShop finBYChuShop_IdSanPham(@Param("idSanPham") String idSanPham);
    ChuShop findByIdShop(@Param("idShop") String idShop);

}
