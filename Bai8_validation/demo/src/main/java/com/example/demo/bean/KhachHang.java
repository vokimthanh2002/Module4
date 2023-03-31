package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class KhachHang {
    @Id
    private String maKhachHang;
    private String tenKhachHang;
    private String gioiTinh;
    private String soDienThoai;
    private String email;
    private String ngaySinh;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maTaiKhoan", referencedColumnName = "maTaiKhoan")
    private TaiKhoan taiKhoan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maPhuongXa", referencedColumnName = "maPhuongXa")
    private PhuongXa phuongXa;


    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private Set<DanhGia> danhGia;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private Set<DangKiDichVu> dangKiDichVu;
}
