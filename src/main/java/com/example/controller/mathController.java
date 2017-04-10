package com.example.controller;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Math Controller
 */

import com.example.model.Area;
import com.example.model.Calculate;
import com.example.model.MathService;
import com.example.model.Volume;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class mathController {

    @GetMapping("/pi")
    public String getPI() {
        return MathService.getPI();
    }

    // Spring Math: Calculate with Querystrings
    @GetMapping("/calculate")
    public String calculate(Calculate calculate) {
        return MathService.getCalculate(calculate);
    }

    // Spring Math: Sum with Querystrings
    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, String> querystring) {
        return MathService.getSum(querystring);
    }

    // Spring Math: Calculate Volume
    @RequestMapping("/volume/{length}/{width}/{height}")
    public String volume(Volume volume) {
        return MathService.getVolume(volume);
    }

    // Spring Math: Calculate Area for a Rectangle or Circle
    @PostMapping(value="/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String area(Area area) {
        return MathService.getArea(area);
    }
}
