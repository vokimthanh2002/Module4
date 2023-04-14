package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.Quyen;
import com.example.quanlythucung.repository.QuyenRepository;
import com.example.quanlythucung.service.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuyenServiceImpl implements QuyenService {
    @Autowired
    QuyenRepository repository;
    @Override
    public List<Quyen> findAllQuyen() {
        return repository.findAll();
    }

    @Override
    public Quyen finById(String idQuyen) {
        return repository.findById(idQuyen).orElse(null);
    }
}
