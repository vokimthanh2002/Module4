package com.example.music_player_app.repository;

import com.example.music_player_app.entyti.Music;

import java.util.List;

public interface IMusicRepository {
    void create(Music music);
    void update(Music music);
    void delete(Music music);
    Music finById(String id);
    List<Music> findByNam(String tenBaiHat);
    List<Music> getAll();

}
