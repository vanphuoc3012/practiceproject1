package com.likelion.springdatajdbc.service;

import com.likelion.springdatajdbc.model.Tutorial;

import java.util.List;

public interface TutorialService {
    List<Tutorial> findAll();

    List<Tutorial> findByTitleContaining(String title);

    Tutorial findById(Long id);

    boolean existById(Long id);

    void deleteById(Long id);

    void deleteAll();

    List<Tutorial> findByPublished(boolean b);

    Tutorial save(Tutorial tutorial);
}
