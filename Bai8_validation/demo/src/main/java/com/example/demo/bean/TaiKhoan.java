package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;

@Entity
public class TaiKhoan {
    @Id
    private String maTaiKhoan;
    private String tenTaiKhoan;
    private String mauKhau;
    private String trangThai;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;

    @OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
    private KhachHang khachHang;

    @OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
    private NhanVien nhanVien;

    @OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
    private ChuShop chuShop;

    public TaiKhoan() {
    }

    public TaiKhoan(String maTaiKhoan, String tenTaiKhoan, String mauKhau, String trangThai, Role role) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.mauKhau = mauKhau;
        this.trangThai = trangThai;
        this.role = role;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMauKhau() {
        return mauKhau;
    }

    public void setMauKhau(String mauKhau) {
        this.mauKhau = mauKhau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
