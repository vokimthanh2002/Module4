package com.example.photo_of_the_day_spring_boot.service;

import com.example.photo_of_the_day_spring_boot.entyti.Evaluate;
import com.example.photo_of_the_day_spring_boot.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    PhotoRepository photoRepository;
    @Override
    public void addEvaluate(Evaluate evaluate) {
        photoRepository.save(evaluate);
    }

    @Override
    public List<Evaluate> getAll() {
        return (List<Evaluate>) photoRepository.findAll();
    }

    @Override
    public Page<Evaluate> findAllWithPaging(Pageable pageable) {
        return  photoRepository.findAll(pageable);
    }

    @Override
    public Evaluate findById(int id) {
        return photoRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Evaluate evaluate) {
        photoRepository.save(evaluate);
    }

}
