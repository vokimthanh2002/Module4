package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.DichVu;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DichVuService {
    void addDichVu(DichVu dichVu);
    void updateDichVu(DichVu dichVu);
    void deleteDichVu(DichVu dichVu);
    DichVu finByName(String tenDichVu);
    List<DichVu> findAllDichVu();
    List<DichVu>  findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap);

    DichVu findByDichVuById( String idDichVu);
}
