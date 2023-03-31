package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;

@Entity
public class DangKiDichVu {
    @Id
    private String maDangKiDichVu;
    private String trangThai;
    private String canNang;
    private String chungLoai;
    private String thoiGian;
    private int soLuong;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maDichVu", referencedColumnName = "maDichVu")
    private DichVu dichVu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien")
    private NhanVien nhanVien;

}
