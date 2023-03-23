package com.example.photo_of_the_day_spring_boot.service;

import com.example.photo_of_the_day_spring_boot.entyti.Evaluate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhotoService {

    void addEvaluate(Evaluate evaluate);
    List<Evaluate> getAll();
    Page<Evaluate> findAllWithPaging(Pageable pageable);
    Evaluate findById(int id);
    void update(Evaluate evaluate);
}
