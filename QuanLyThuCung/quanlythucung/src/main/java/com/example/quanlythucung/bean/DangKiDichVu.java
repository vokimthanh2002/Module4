package com.example.quanlythucung.bean;

import javax.persistence.*;

@Entity
public class DangKiDichVu {
    @Id
    private String idDKDV;
    private String ngayHen;
    private double thanhTien;
    private String hinhThucThanhToan;
    private String ghiChu;
    private int soLuong;
    @ManyToOne
    @JoinColumn(name = "idKH", referencedColumnName = "idKH")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "idDichVu", referencedColumnName = "idDichVu")
    private DichVu dichVu;

    @ManyToOne
    @JoinColumn(name = "idShop", referencedColumnName = "idShop")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "idNV", referencedColumnName = "idNV")
    private NhanVien nhanVien;

    public DangKiDichVu() {
    }

    public String getIdDKDV() {
        return idDKDV;
    }

    public void setIdDKDV(String idDKDV) {
        this.idDKDV = idDKDV;
    }

    public String getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(String ngayHen) {
        this.ngayHen = ngayHen;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
