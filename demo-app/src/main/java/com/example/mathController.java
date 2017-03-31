package com.example;

/**
 * Created by trainer18 on 3/30/17.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class mathController {
    @GetMapping("/pi")
    public String helloWorld() {
        return "3.141592653589793";
    }
}
