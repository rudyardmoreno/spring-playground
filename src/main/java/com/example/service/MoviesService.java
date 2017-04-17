package com.example.service;

import com.example.model.Movies;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Rudyard Moreno on 4/17/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 7 - MoviesService
 */
@Service
public class MoviesService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Movies getMovies(String query) {
        return this.restTemplate.getForObject(
                "http://www.omdbapi.com/?s={query}",
                Movies.class,
                query
        );
    }
}
