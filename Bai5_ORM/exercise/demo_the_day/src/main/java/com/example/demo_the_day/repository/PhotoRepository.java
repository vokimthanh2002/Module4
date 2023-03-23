package com.example.demo_the_day.repository;


import com.example.demo_the_day.entyti.Evaluate;

import java.util.List;

public interface PhotoRepository {
    void addEvaluate(Evaluate evaluate);
    List<Evaluate> getAll();
    Evaluate findById(int id);
    void update(Evaluate evaluate);
}
