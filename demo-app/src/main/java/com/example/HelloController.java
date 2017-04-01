package com.example;

/**
 * Created by trainer18 on 3/30/17.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello from Spring";
    }
}
