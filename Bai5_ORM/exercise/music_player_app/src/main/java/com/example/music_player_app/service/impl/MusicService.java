package com.example.music_player_app.service.impl;

import com.example.music_player_app.entyti.Music;
import com.example.music_player_app.repository.IMusicRepository;
import com.example.music_player_app.repository.impl.MusicRepository;
import com.example.music_player_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;
    @Override
    public void create(Music music) {
        musicRepository.create(music);
    }

    @Override
    public List<Music> findByNam(String tenBaiHat) {
        return musicRepository.findByNam(tenBaiHat);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public void delete(Music music) {
        musicRepository.delete(music);
    }

    @Override
    public Music finById(String id) {
        return musicRepository.finById(id);
    }

    @Override
    public List<Music> getAll() {
        return musicRepository.getAll();
    }
}
