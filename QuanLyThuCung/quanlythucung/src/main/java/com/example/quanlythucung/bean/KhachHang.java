package com.example.quanlythucung.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class KhachHang {
    @Id
    private String idKH;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    @OneToOne
    @JoinColumn(name = "tenDangNhap", referencedColumnName = "tenDangNhap")
    private TaiKhoan taiKhoan;


    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    @JsonManagedReference
    private  List<KhachHangShop> khachHangShops;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "khachhang_shop",
//            joinColumns = @JoinColumn(name = "idKH"),
//            inverseJoinColumns = @JoinColumn(name = "idShop"))
//    @JsonManagedReference
//    private List<Shop> shops;

    public KhachHang() {
    }

    public List<KhachHangShop> getKhachHangShops() {
        return khachHangShops;
    }

    public void setKhachHangShops(List<KhachHangShop> khachHangShops) {
        this.khachHangShops = khachHangShops;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
