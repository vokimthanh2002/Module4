package com.example.quanlythucung.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    private String idBlog;
    private String tenBlog;
    private String tacGia;
    private String gioDang;
}
