package com.likelion.springdatajdbc.service;

import com.likelion.springdatajdbc.model.Tutorial;
import com.likelion.springdatajdbc.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TutorialServiceImpl implements TutorialService{
    private TutorialRepository tutorialRepository;

    @Autowired
    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public Tutorial findById(Long id) throws NoSuchElementException {
        return tutorialRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found any tutorial with id: " + id)
        );
    }

    @Override
    public boolean existById(Long id) {
        return tutorialRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<Tutorial> findByPublished(boolean b) {
        return tutorialRepository.findByPublished(b);
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }
}
