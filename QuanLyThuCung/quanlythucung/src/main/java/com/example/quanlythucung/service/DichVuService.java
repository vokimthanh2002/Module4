package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DichVuService {
    void addDichVu(DichVu dichVu);
    void updateDichVu(DichVu dichVu);
    void deleteDichVu(DichVu dichVu);
//    DichVu finByName(String tenDichVu);
    List<DichVu> findAllDichVu();
    Page<DichVu> findAllDichVuPage(Pageable pageable);
    List<DichVu>  findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);
    List<DichVu> findByTenDichVuContains(String tenDichVu);
    DichVu findByDichVuById( String idDichVu);
    List<DichVu> findByAll(String tenDichVu,String loaiDichVu,String moTa);
}
