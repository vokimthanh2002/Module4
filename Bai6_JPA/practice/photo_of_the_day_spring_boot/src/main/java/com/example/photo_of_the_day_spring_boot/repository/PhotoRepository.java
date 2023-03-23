package com.example.photo_of_the_day_spring_boot.repository;



import com.example.photo_of_the_day_spring_boot.entyti.Evaluate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PhotoRepository extends PagingAndSortingRepository<Evaluate,Integer> {

}
