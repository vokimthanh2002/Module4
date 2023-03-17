package com.example.music_player_app.service;

import com.example.music_player_app.entyti.Music;

import java.util.List;

public interface IMusicService {
    void create(Music music);
    List<Music> findByNam(String tenBaiHat);
    void update(Music music);
    void delete(Music music);
    Music finById(String id);
    List<Music> getAll();
}
