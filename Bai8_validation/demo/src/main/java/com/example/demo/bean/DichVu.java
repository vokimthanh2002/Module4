package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DichVu {
    @Id
    private String maDichVu;
    private String tenDichVu;
    private String chungLoai;
    private double giaDichVu;
    @OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
    private Set<DangKiDichVu> dangKiDichVu;

    public DichVu() {
    }

    public DichVu(String maDichVu, String tenDichVu, String chungLoai, double giaDichVu) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.chungLoai = chungLoai;
        this.giaDichVu = giaDichVu;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getChungLoai() {
        return chungLoai;
    }

    public void setChungLoai(String chungLoai) {
        this.chungLoai = chungLoai;
    }

    public double getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }
}
