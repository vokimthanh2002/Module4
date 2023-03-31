package com.example.validate_music.service;

import com.example.validate_music.bean.Music;
import com.example.validate_music.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService{
    @Autowired
    MusicRepository musicRepository;
    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }
}
