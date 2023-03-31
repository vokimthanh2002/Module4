package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuanHuyen {
    @Id
    private String maQuanHuyen;
    private String tenQuanHuyen;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maTinhThanh", referencedColumnName = "maTinhThanh")
    private TinhThanh tinhThanh;

    @OneToMany(mappedBy = "quanHuyen", cascade = CascadeType.ALL)
    private Set<PhuongXa> phuongXa;

    public QuanHuyen(String maQuanHuyen, String tenQuanHuyen, TinhThanh tinhThanh) {
        this.maQuanHuyen = maQuanHuyen;
        this.tenQuanHuyen = tenQuanHuyen;
        this.tinhThanh = tinhThanh;
    }

    public QuanHuyen() {
    }

    public String getMaQuanHuyen() {
        return maQuanHuyen;
    }

    public void setMaQuanHuyen(String maQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
    }

    public String getTenQuanHuyen() {
        return tenQuanHuyen;
    }

    public void setTenQuanHuyen(String tenQuanHuyen) {
        this.tenQuanHuyen = tenQuanHuyen;
    }

    public TinhThanh getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(TinhThanh tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
}
