package com.example.quanlythucung.form;

import com.example.quanlythucung.bean.*;

import java.util.List;

public class DangKiDichVuForm {
    private String idKH;
    private String matTruocCCCD;
    private String matSauCCCD;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private TaiKhoan taiKhoan;
    private List<KhachHangShop> khachHangShops;
    private String idDKDV;
    private String ngayHen;
    private double thanhTien;
    private String hinhThucThanhToan;
    private String ghiChu;
    private int soLuong;
    private KhachHang khachHang;
    private DichVu dichVu;
    private Shop shop;
    private NhanVien nhanVien;

    public DangKiDichVuForm() {
    }

    public String getMatTruocCCCD() {
        return matTruocCCCD;
    }

    public void setMatTruocCCCD(String matTruocCCCD) {
        this.matTruocCCCD = matTruocCCCD;
    }

    public String getMatSauCCCD() {
        return matSauCCCD;
    }

    public void setMatSauCCCD(String matSauCCCD) {
        this.matSauCCCD = matSauCCCD;
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

    public List<KhachHangShop> getKhachHangShops() {
        return khachHangShops;
    }

    public void setKhachHangShops(List<KhachHangShop> khachHangShops) {
        this.khachHangShops = khachHangShops;
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
