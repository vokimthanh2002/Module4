package com.example.quanlythucung.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class DichVu {
    @Id
    private String idDichVu;
    private String tenDichVu;
    private String loaiDichVu;
    private String linkImg;
    private String moTa;
    private double chiPhi;
    @ManyToOne
    @JoinColumn(name = "idShop", referencedColumnName = "idShop")
    private Shop shop;

    public DichVu() {
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(String idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
