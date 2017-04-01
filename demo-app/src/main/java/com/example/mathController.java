package com.example;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Math Controller
 */

import com.example.model.MathService;
import com.example.model.Calculate;
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

}
