package com.example.quanlythucung.service;

import com.example.quanlythucung.bean.Quyen;

import java.util.List;

public interface QuyenService {
    List<Quyen> findAllQuyen();
    Quyen finById(String idQuyen);
}
