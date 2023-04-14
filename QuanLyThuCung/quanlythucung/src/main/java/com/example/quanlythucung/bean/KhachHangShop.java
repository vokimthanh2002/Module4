package com.example.quanlythucung.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class KhachHangShop {
    @Id
    public String idKhShop;

    @ManyToOne
    @JoinColumn(name = "idShop", referencedColumnName = "idShop")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "idKH", referencedColumnName = "idKH")
    private KhachHang khachHang;

    public KhachHangShop() {
    }

    public String getIdKhShop() {
        return idKhShop;
    }

    public void setIdKhShop(String idKhShop) {
        this.idKhShop = idKhShop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
