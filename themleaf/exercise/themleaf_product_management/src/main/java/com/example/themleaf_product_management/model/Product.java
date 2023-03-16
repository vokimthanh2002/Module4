package com.example.themleaf_product_management.model;

//https://github.com/vokimthanh2002/Module4/tree/main/themleaf/exercise/themleaf_product_management

public class Product {
    int idSanPham;
    String tenSanPham;
    Double gia;
    int soLuong;
    String mauSac;
    String moTa;
    public Product() {
    }

    public Product(int idSanPham, String tenSanPham, Double gia, int soLuong, String mauSac, String moTa) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idSanPham=" + idSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", mauSac='" + mauSac + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }

}
