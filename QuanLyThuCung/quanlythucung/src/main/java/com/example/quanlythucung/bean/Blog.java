package com.example.quanlythucung.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Blog {

    @Id

    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    @Size(min = 10)
    @Column(columnDefinition = "text")
    private String content;
    private String linkImg;
    private String date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "tenDangNhap", referencedColumnName = "tenDangNhap")
    private TaiKhoan taiKhoan;

    public Blog() {
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public Blog(Long id, String title, String content, String linkImg, String date, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.linkImg = linkImg;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
