package com.example.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Rudyard Moreno on 4/15/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit
 */
@Component
@ConfigurationProperties("myService")
public class WordCountConfig {
    private String words;
    private String delimiter;

    public String getWords() { return words; }
    public String getDelimiter() { return delimiter; }

    public void setWords(String value) { words=value; }
    public void setDelimiter(String value) { delimiter=value; }

}
