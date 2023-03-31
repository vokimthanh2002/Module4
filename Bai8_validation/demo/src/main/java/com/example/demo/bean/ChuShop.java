package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ChuShop {
    @Id
    private String maChuShop;
    private String tenChuShop;
    private String tenShop;
    private String soDienThoai;
    private String email;
    private String trangThai;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maTaiKhoan", referencedColumnName = "maTaiKhoan")
    private TaiKhoan taiKhoan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maPhuongXa", referencedColumnName = "maPhuongXa")
    private PhuongXa phuongXa;

    @OneToMany(mappedBy = "chuShop", cascade = CascadeType.ALL)
    private Set<TraPhi> traPhi;

    @OneToMany(mappedBy = "chuShop", cascade = CascadeType.ALL)
    private Set<PhanHoi> phanHoi;

}
