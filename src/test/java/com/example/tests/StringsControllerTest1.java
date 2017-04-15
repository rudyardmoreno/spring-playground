package com.example.tests;

/*
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test StringsController
 */

import com.example.controller.StringsController;
import com.example.model.WordCountConfig;
import com.example.model.WordCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(StringsController.class)
@AutoConfigureMockMvc(secure=false)

public class StringsControllerTest1 {

    @Autowired
    MockMvc mvc;

    @MockBean
    WordCounter wordCounter;

    @MockBean
    WordCountConfig wordCountConfig;

    Map<String, Integer> response = new LinkedHashMap<>();
    String request;

    @Before
    public void test1Setup(){
        request ="to the moon to the moon to the moon";
        response.put("to",3);
        response.put("the",3);
        response.put("moon",3);

        when(wordCounter.count(request)).thenReturn(response);
    }

    @Test
    public void test1() throws Exception {
        assertEquals(response,wordCounter.count(request));
    }

}
