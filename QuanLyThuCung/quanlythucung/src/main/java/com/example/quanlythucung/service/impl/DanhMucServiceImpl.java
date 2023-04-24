package com.example.quanlythucung.service.impl;

import com.example.quanlythucung.bean.DanhMuc;
import com.example.quanlythucung.repository.DanhMucRepository;
import com.example.quanlythucung.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    DanhMucRepository repository;
    @Override
    public List<DanhMuc> findAll() {
        return repository.findAll();
    }
}
