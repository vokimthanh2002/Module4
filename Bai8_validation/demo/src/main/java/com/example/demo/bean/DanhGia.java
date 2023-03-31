package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DanhGia {
    @Id
    private String maDanhGia;
    private String noiDung;
    private int soSao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

    @OneToMany(mappedBy = "danhGia", cascade = CascadeType.ALL)
    private Set<PhanHoi> phanHoi;
}
