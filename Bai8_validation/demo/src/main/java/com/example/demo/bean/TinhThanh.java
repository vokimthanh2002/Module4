package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.CascadeType;
import javax.persistence.*;
import java.util.Set;

@Entity
public class TinhThanh {
    @Id
    private String maTinhThanh;
    private String tenTinhThanh;
    @OneToMany(mappedBy = "tinhThanh", cascade = CascadeType.ALL)
    private Set<QuanHuyen> quanHuyen;

    public TinhThanh(String maTinhThanh, String tenTinhThanh) {
        this.maTinhThanh = maTinhThanh;
        this.tenTinhThanh = tenTinhThanh;
    }

    public TinhThanh() {
    }

    public String getMaTinhThanh() {
        return maTinhThanh;
    }

    public void setMaTinhThanh(String maTinhThanh) {
        this.maTinhThanh = maTinhThanh;
    }

    public String getTenTinhThanh() {
        return tenTinhThanh;
    }

    public void setTenTinhThanh(String tenTinhThanh) {
        this.tenTinhThanh = tenTinhThanh;
    }
}
