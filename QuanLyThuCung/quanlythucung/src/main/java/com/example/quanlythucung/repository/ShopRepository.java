package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,String> {
    Shop findByChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
    @Query("select s from Shop as s join DichVu as dv on dv.shop.idShop=s.idShop where dv.idDichVu=?1")
    Shop findByIdDichVu(@Param("idDichVu") String idDichVu);


    List<Shop> findByTrangThai(String trangThai);
}
