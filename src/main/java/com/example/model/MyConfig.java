package com.example.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Rudyard Moreno on 4/10/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 6 - Spring IoC and Config
 * MyConfig class
 */
@Component
@ConfigurationProperties("myService")
public class MyConfig {
    private String delimiter;

    public String getDelimiter(){ return delimiter; }
    public void setDelimiter(String value) { delimiter=value; }
}
