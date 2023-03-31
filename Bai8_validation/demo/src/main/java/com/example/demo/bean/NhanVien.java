package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NhanVien {
    @Id
    private String maNhanVien;
    private String tenNhanVien;
    private String anhNhanVien;
    private String gioiTinh;
    private String cmnd;
    private String soDienThoai;
    private String email;
    private String ngaySinh;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maTaiKhoan", referencedColumnName = "maTaiKhoan")
    private TaiKhoan taiKhoan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maPhuongXa", referencedColumnName = "maPhuongXa")
    private PhuongXa phuongXa;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private Set<TinTuc> tinTuc;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private Set<DangKiDichVu> dangKiDichVu;
}
