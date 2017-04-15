package com.example.controller;

import com.example.model.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Rudyard Moreno on 4/10/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 6 - Spring IoC and Config
 * Strings Controller
 */

@RestController
public class StringsController {

    @Autowired
    WordCounter wordCounter;

    public StringsController(WordCounter wordCounter) {
        this.wordCounter=wordCounter;
    }

    @PostMapping("/words/count")
    public Map<String,Integer> getWordsCount(@RequestBody String rawBody) {
        return wordCounter.count(rawBody);
    }
}
