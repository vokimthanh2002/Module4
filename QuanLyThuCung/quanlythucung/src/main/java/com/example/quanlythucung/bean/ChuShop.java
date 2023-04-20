package com.example.quanlythucung.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ChuShop {
    @Id
    private String idChuShop;
    private String tenChuShop;
    private String gioiTinh;
    private String ngaySinh;
    private String cccd;
    private String sdt;
    private String email;
    private String diaChi;
    private String matTruocCCCD;
    private String matSauCCCD;
    @OneToOne
    @JoinColumn(name = "tenDangNhap", referencedColumnName = "tenDangNhap")
    private TaiKhoan taiKhoan;

    public ChuShop() {
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

    public String getIdChuShop() {
        return idChuShop;
    }

    public void setIdChuShop(String idChuShop) {
        this.idChuShop = idChuShop;
    }

    public String getTenChuShop() {
        return tenChuShop;
    }

    public void setTenChuShop(String tenChuShop) {
        this.tenChuShop = tenChuShop;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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
