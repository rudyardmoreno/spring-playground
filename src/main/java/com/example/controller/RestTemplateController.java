package com.example.controller;

/*
 * Created by Rudyard Moreno on 04/05/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 7 - RestTemplates
 * RestTemplate Controller
 */

import com.example.model.Titles;
import com.example.service.MoviesService;
import com.example.service.ZenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestTemplateController {

    @Autowired
    ZenService zenService;

    @Autowired
    MoviesService moviesService;

    @GetMapping("/zenservice")
    public String getZenService() {
        return zenService.getMessage();
    }

    @GetMapping("/movies")
    public List<Titles> getMovies(@RequestParam String q) {
        return moviesService.getMovies(q).getSearch();
    }

}
