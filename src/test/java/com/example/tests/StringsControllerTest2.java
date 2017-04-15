package com.example.tests;

/*
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test StringsController
 */

import com.example.model.WordCountConfig;
import com.example.model.WordCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(secure=false)

public class StringsControllerTest2 {

    @Autowired
    MockMvc mvc;

    @Autowired
    WordCounter wordCounter;

    @Autowired
    WordCountConfig wordCountConfig;

    Map<String, Integer> response = new LinkedHashMap<>();
    String request;

    @Before
    public void test1Setup(){
        request ="To The MOON to the moon to the moon";
        response.put("to",3);
        //response.put("the",3);
        response.put("moon",3);
    }

    @Test
    public void test1() throws Exception {
        assertEquals(response,wordCounter.count(request));
    }

    @Test
    public void test2() throws Exception {
        List<String> wordsSkip = new ArrayList<String>();

        wordsSkip.add("the");
        wordsSkip.add("an");
        wordsSkip.add("a");

        assertEquals(wordCountConfig.getDelimiter()," ");
        assertEquals(wordCountConfig.getCaseSensitive(),false);
        assertEquals(wordCountConfig.getWords().getSkip(),wordsSkip);
    }

    @Test
    public void test3() throws Exception{
        String words;

        words="to the moon to the moon";

        MockHttpServletRequestBuilder request = post("/words/count")
                .contentType(MediaType.TEXT_PLAIN)
                .content(words);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.to", is(2)))
                .andExpect( jsonPath("$.the").doesNotExist())
                .andExpect(jsonPath("$.moon", is(2)))

        ;
    }
}
