package com.example.validate_music.repository;

import com.example.validate_music.bean.Music;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MusicRepository  extends PagingAndSortingRepository<Music,Integer> {
}
