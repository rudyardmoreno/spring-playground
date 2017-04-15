package com.example.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Rudyard Moreno on 4/15/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit
 */
@Component
@ConfigurationProperties("wordCount")
public class WordCountConfig {
    private String delimiter;
    private boolean caseSensitive;
    private Words words;

    public String getDelimiter() { return delimiter; }
    public boolean getCaseSensitive() { return caseSensitive; }
    public Words getWords() { return words; }
    public boolean isCaseSensitive() { return caseSensitive; }

    public void setDelimiter(String value) { delimiter=value; }
    public void setCaseSensitive(boolean value) {caseSensitive=value; }
    public void setWords(Words value) { words=value; }

    public static class Words {
        private List<String> skip;
        public List<String> getSkip() { return skip; }
        public void setSkip(List<String> value) { skip=value;}
    }

}
