package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.DichVu;
import com.example.quanlythucung.repository.DichVuRepository;
import com.example.quanlythucung.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    DichVuRepository repository;

    @Override
    public void addDichVu(DichVu dichVu) {
        repository.save(dichVu);
    }

    @Override
    public void updateDichVu(DichVu dichVu) {
        repository.save(dichVu);
    }

    @Override
    public void deleteDichVu(DichVu dichVu) {
        repository.delete(dichVu);
    }

//    @Override
//    public DichVu finByName(String tenDichVu) {
//        return repository.findByTenDichVuContains(tenDichVu);
//    }

    @Override
    public List<DichVu> findAllDichVu() {
        return repository.findAll();
    }

    @Override
    public Page<DichVu> findAllDichVuPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<DichVu> findByShop_ChuShop_TaiKhoan_TenDangNhap(String tenDangNhap) {
        return repository.findByShop_ChuShop_TaiKhoan_TenDangNhap(tenDangNhap);
    }

    @Override
    public List<DichVu> findByTenDichVuContains(String tenDichVu) {
        return repository.findByTenDichVuContains(tenDichVu);
    }

    @Override
    public DichVu findByDichVuById(String idDichVu) {
        return repository.findByDichVuById(idDichVu);
    }

    @Override
    public List<DichVu> findByAll(String tenDichVu, String loaiDichVu, String moTa) {
        return repository.findByTenDichVuContainsOrLoaiDichVuContainsOrMoTaContains(tenDichVu,loaiDichVu,moTa);
    }
}
