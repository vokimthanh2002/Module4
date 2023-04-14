package com.example.quanlythucung.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shop {
    @Id
    private String idShop;
    private String tenShop;
    private String ngayDK;
    private String moTa;
    private String email;
    private String hotLine;
    private String diaChi;
    private String trangThai;
    @OneToOne
    @JoinColumn(name = "idChuShop", referencedColumnName = "idChuShop")
    private ChuShop chuShop;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    @JsonManagedReference
    private  List<KhachHangShop> khachHangShops;

//    @ManyToMany(mappedBy = "shops")
//    @JsonBackReference
//    private List<KhachHang> khachHangs;

    public Shop() {
    }



    public Shop(String idShop) {
        this.idShop = idShop;
    }

    public String getIdShop() {
        return idShop;
    }

    public void setIdShop(String idShop) {
        this.idShop = idShop;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }

    public String getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(String ngayDK) {
        this.ngayDK = ngayDK;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotLine() {
        return hotLine;
    }

    public void setHotLine(String hotLine) {
        this.hotLine = hotLine;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ChuShop getChuShop() {
        return chuShop;
    }

    public void setChuShop(ChuShop chuShop) {
        this.chuShop = chuShop;
    }
}
