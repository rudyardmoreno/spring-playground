package com.example;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Endpoints Controller
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointsController {
    @GetMapping("/EndPointController")
    public String helloWorld() {
        return "This is Endpoints Controller!";
    }
}
