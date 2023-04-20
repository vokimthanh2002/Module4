package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface KhachHangRepository extends JpaRepository<KhachHang,String> {
   @Query("select DISTINCT kh from KhachHang as kh join KhachHangShop as kh_s on kh.idKH = kh_s.khachHang.idKH join Shop as s on kh_s.shop.idShop=s.idShop join ChuShop as cs on s.chuShop.idChuShop = cs.idChuShop join TaiKhoan as tk on cs.taiKhoan.tenDangNhap= tk.tenDangNhap  where tk.tenDangNhap = ?1")
    List<KhachHang> findByListKhachHang(@Param("tenDangNhap") String tenDangNhap);

   KhachHang findByTaiKhoan_TenDangNhap(String tenDangNhap);
}
