package com.example.music_player_app.entyti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @Column(columnDefinition = "varchar(10)")
    private String idBaiHat;
    private String tenBaiHat;
    private String ngheSi;
    private String theLoai;
    private String url;

    public Music() {
    }

    public Music(String idBaiHat, String tenBaiHat, String ngheSi, String theLoai, String url) {
        this.idBaiHat = idBaiHat;
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
        this.url = url;
    }

    public String getIdBaiHat() {
        return idBaiHat;
    }

    public void setIdBaiHat(String idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Music{" +
                "idBaiHat='" + idBaiHat + '\'' +
                ", tenBaiHat='" + tenBaiHat + '\'' +
                ", ngheSi='" + ngheSi + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
