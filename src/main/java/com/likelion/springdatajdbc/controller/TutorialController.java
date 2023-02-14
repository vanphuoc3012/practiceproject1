package com.likelion.springdatajdbc.controller;

import com.likelion.springdatajdbc.model.Tutorial;
import com.likelion.springdatajdbc.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class TutorialController {

    public final TutorialService tutorialService;

    @Autowired
    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @PostMapping("/tutorials")
    public ResponseEntity<?> createNewTutorial(@RequestBody Tutorial tutorial) {
        Tutorial savedTutorial = tutorialService.save(tutorial);
        return ResponseEntity.ok(savedTutorial.getId());
    }

    @GetMapping("/tutorials")
    public ResponseEntity<?> findTutorials(@RequestParam(name = "title", required = false) String title) {
        if(title == null) return ResponseEntity.ok(tutorialService.findAll());
        return ResponseEntity.ok(tutorialService.findByTitleContaining(title));
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<?> getTutorialById(@PathVariable(name = "id") Long id) {
        try {
            Tutorial tutorial = tutorialService.findById(id);
            return ResponseEntity.ok(tutorial);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any tutorial with ID: " + id);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<?> updateTutorial(@RequestBody Tutorial tutorial,
                                            @PathVariable(name = "id") Long id) {
        if(id != tutorial.getId()) return ResponseEntity.badRequest().body("Bad request");
        if(!tutorialService.existById(id)) return ResponseEntity.notFound().build();

        tutorialService.save(tutorial);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<?> deleteTutorial(@PathVariable(name = "id") Long id) {
        tutorialService.deleteById(id);
        return ResponseEntity.ok("Tutorial has been deleted");
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<?> deleteAllTutorial() {
        tutorialService.deleteAll();
        return ResponseEntity.ok("Deleted all tutorials");
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<?> findPublishedTutorials() {
        return ResponseEntity.ok(tutorialService.findByPublished(true));
    }
}
