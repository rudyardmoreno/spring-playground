package com.example;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Math Controller
 */

import com.example.model.MathService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class mathController {
    MathService mathService = new MathService();

    // Spring Math: PI with GET
    @GetMapping("/pi")
    public String helloWorld() {
        return mathService.getPI();
    }

    // Spring Math: Calculate with Querystrings
    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "operation", defaultValue = "add") String operation,
                            @RequestParam int x,
                            @RequestParam int y) {
        return mathService.getCalculate(operation,x,y);
    }

    // Spring Math: Sum with Querystrings
    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, String> querystring) {
        return mathService.getSum(querystring);
    }

}
