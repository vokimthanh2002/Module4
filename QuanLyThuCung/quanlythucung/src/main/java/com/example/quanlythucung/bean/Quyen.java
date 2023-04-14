package com.example.quanlythucung.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Quyen {
    @Id
    private String idQuyen;
    private String tenQuyen;

    public Quyen(String idQuyen, String tenQuyen) {
        this.idQuyen = idQuyen;
        this.tenQuyen = tenQuyen;
    }

    public Quyen() {
    }

    public String getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(String idQuyen) {
        this.idQuyen = idQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }
}
