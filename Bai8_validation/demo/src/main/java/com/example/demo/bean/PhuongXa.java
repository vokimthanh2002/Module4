package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PhuongXa {
    @Id
    private String maPhuongXa;
    private String tenPhuongXa;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maQuanHuyen", referencedColumnName = "maQuanHuyen")
    private QuanHuyen quanHuyen;

    @OneToMany(mappedBy = "phuongXa", cascade = CascadeType.ALL)
    private Set<KhachHang> khachHang;

    @OneToMany(mappedBy = "phuongXa", cascade = CascadeType.ALL)
    private Set<NhanVien> nhanVien;

    @OneToMany(mappedBy = "phuongXa", cascade = CascadeType.ALL)
    private Set<ChuShop> chuShop;

}
