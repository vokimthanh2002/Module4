package com.example.quanlythucung.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class TaiKhoan {
    @Id
    @NotBlank(message = "Khong duoc de trong")
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String tenDangNhap;

    @Size(min = 6, max = 16 ,message = "Mat khau it nhat tu 6-16 ki tu")
    private String matKhau;
    private String trangThai;
    private String ngayDk;
    @ManyToOne
    @JoinColumn(name = "idQuyen", referencedColumnName = "idQuyen")
    private Quyen quyen;

    public TaiKhoan() {
    }


    public String getNgayDk() {
        return ngayDk;
    }

    public void setNgayDk(String ngayDk) {
        this.ngayDk = ngayDk;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }
}
