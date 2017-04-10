package com.example.controller;

/*
 * Created by Rudyard Moreno on 04/05/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Lessons Controller
 */

import com.example.model.data.entities.Lesson;
import com.example.model.data.repositories.LessonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Lesson getOne(@PathVariable Long id) {
        return this.repository.findOne(id);
    }

    @PatchMapping("/{id}")
    public Lesson update(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.repository.delete(id);
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

}
