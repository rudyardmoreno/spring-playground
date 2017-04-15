package com.example.model;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudyard Moreno on 4/10/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 6 - Spring IoC and Config
 * WordCounter class
 */
@Service
public class WordCounter {
    private String words;

    WordCountConfig wordCountConfig;

    public WordCounter(WordCountConfig value) {
        wordCountConfig=value;
        setWords("");
    }

    public String getWords(){ return words; }

    public void setWords(String value) { words=value; }

    public Map<String,Integer> count(String words) {
        Map<String,Integer> wordCount = new HashMap<>();
        int cnt=0;
        for (String word : words.split(wordCountConfig.getDelimiter())) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word,1);
            } else {
                wordCount.put(word,wordCount.get(word)+1);

            }
        }
        return wordCount;
    }

}
