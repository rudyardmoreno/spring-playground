package com.example;

/**
 * Created by trainer18 on 3/30/17.
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
