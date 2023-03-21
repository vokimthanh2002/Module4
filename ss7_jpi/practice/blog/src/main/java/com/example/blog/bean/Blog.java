package com.example.blog.bean;

import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String content;
    private String linkImg;
    private String date;

    public Blog() {
    }

    public Blog(String title, String content, String linkImg, String date) {
        this.title = title;
        this.content = content;
        this.linkImg = linkImg;
        this.date = date;
    }

    public Blog(Long id, String title, String content, String linkImg) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.linkImg = linkImg;
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
}
