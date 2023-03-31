package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;

@Entity
public class PhanHoi {
    @Id
    private String maPhanHoi;
    private String noiDung;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maChuShop", referencedColumnName = "maChuShop")
    private ChuShop chuShop;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maDanhGia", referencedColumnName = "maDanhGia")
    private DanhGia danhGia;
}
