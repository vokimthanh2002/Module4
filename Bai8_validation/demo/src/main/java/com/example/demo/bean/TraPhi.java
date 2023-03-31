package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;

@Entity
public class TraPhi {
    @Id
    private String maTraPhi;
    private String thoiGian;
    private double soTien;
    private String trangThai;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maChuShop", referencedColumnName = "maChuShop")
    private ChuShop chuShop;
}
