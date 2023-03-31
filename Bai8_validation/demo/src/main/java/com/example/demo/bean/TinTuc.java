package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;

@Entity
public class TinTuc {
    @Id
    private String maTinTuc;
    private String tnTinTuc;
    private String ngayDang;
    private String noiDung;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien")
    private NhanVien nhanVien;

}
