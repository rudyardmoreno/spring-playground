package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Rudyard Moreno on 4/17/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 7 - RestTemplates
 */
@Service
public class ZenService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String getMessage() {
        return this.restTemplate.getForObject(
                "https://api.github.com/zen",
                String.class
        );
    }
}
