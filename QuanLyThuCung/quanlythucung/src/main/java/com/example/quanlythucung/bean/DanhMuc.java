package com.example.quanlythucung.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idDanhMuc;
    private String tenDanhMuc;

    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL)
    private List<SanPham> sanPhams;

    public DanhMuc() {
    }

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
