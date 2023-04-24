package com.example.quanlythucung.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SanPham {
    @Id

    private String idSanPham;
    private String tenSanPham;
    private double gia;
    @Column(columnDefinition = "varchar(5000)")
    private String moTa;
    private String linkImg;
    @ManyToOne
    @JoinColumn(name = "idShop", referencedColumnName = "idShop")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "idDanhMuc")
    private DanhMuc danhMuc;

    public SanPham() {
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPham sanPham = (SanPham) o;
        return idSanPham.equals(sanPham.idSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSanPham);
    }
}
