package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.ChuShop;
import com.example.quanlythucung.bean.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChuShopRepository extends JpaRepository<ChuShop,String> {
    @Query("select cs from ChuShop cs join Shop as s on cs.idChuShop = s.chuShop.idChuShop join DichVu  as dv on s.idShop=dv.shop.idShop where dv.idDichVu=?1")
    ChuShop finBYChuShop_IdDichVu(@Param("idDichVu") String idDichVu);

    @Query("select cs from ChuShop cs join Shop as s on cs.idChuShop = s.chuShop.idChuShop join SanPham  as sp on s.idShop=sp.shop.idShop where sp.idSanPham=?1")
    ChuShop finBYChuShop_IdSanPham(@Param("idSanPham") String idSanPham);

    @Query("select cs from ChuShop  as cs join Shop as s on cs.idChuShop= s.chuShop.idChuShop where s.trangThai=?1")
    List<ChuShop> findByTrangThai(@Param("trangThai") String trangThai);

    @Query("select cs from  ChuShop  cs join Shop as s on s.chuShop.idChuShop= cs.idChuShop where s.idShop=?1")
    ChuShop findByIdShop(@Param("idShop") String idShop);
}
