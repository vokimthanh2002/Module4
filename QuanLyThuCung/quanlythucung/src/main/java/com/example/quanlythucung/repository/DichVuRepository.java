package com.example.quanlythucung.repository;

import com.example.quanlythucung.bean.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DichVuRepository extends JpaRepository<DichVu,String> {
//    public DichVu findByTenDichVuContains(String tenDichVu);
    List<DichVu> findByTenDichVuContains(String tenDichVu);
    List<DichVu>  findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);

    @Query("select dv from DichVu as dv join Shop  as s on dv.shop.idShop = s.idShop where dv.idDichVu= ?1")
    DichVu findByDichVuById(@Param("idDichVu") String idDichVu);

    List<DichVu> findByTenDichVuContainsOrLoaiDichVuContainsOrMoTaContains(String tenDichVu,String loaiDichVu,String moTa);
}
