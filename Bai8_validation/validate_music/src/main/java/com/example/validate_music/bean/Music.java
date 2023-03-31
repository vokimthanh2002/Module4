package com.example.validate_music.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Size(max = 800,message = "khong duoc lon hon 800")
    @Column(columnDefinition = "text")
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String nameMusic;

    @NotBlank(message = "Khong duoc de rong")
    @Size(max = 300,message = "khong duoc lon hon 300")
    @Column(columnDefinition = "text")
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String artist;


    @NotBlank(message = "Khong duoc de rong")
    @Size(max = 1000,message = "khong duoc lon hon 1000")
    @Column(columnDefinition = "text")
    private String categoryMusic;


    private String urlMusic;

    public Music(int id, String nameMusic, String artist, String categoryMusic, String urlMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.artist = artist;
        this.categoryMusic = categoryMusic;
        this.urlMusic = urlMusic;
    }

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategoryMusic() {
        return categoryMusic;
    }

    public void setCategoryMusic(String categoryMusic) {
        this.categoryMusic = categoryMusic;
    }

    public String getUrlMusic() {
        return urlMusic;
    }

    public void setUrlMusic(String urlMusic) {
        this.urlMusic = urlMusic;
    }
}
