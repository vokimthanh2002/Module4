package com.example.demo_the_day.repository;

import com.example.demo_the_day.entyti.Evaluate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PhotoRepositoryIml implements PhotoRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addEvaluate(Evaluate evaluate) {
        entityManager.merge(evaluate);
    }

    @Override
    public List<Evaluate> getAll() {
        return entityManager.createQuery("select e from Evaluate e").getResultList();
    }


    @Override
    public Evaluate findById(int id) {
        return entityManager.find(Evaluate.class, id);
    }

    @Override
    public void update(Evaluate evaluate) {
        entityManager.merge(evaluate);
    }
}
