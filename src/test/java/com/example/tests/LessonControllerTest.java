package com.example.tests;

import com.example.model.data.entities.Lesson;
import com.example.model.data.repositories.LessonRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test JSON Controller
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class LessonControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    private Gson gson = new GsonBuilder().create();

    @Test
    @Transactional
    @Rollback
    public void testCreateLesson1() throws Exception{
        Lesson lesson = new Lesson();

        lesson.setTitle("Spring Security 1");
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(lesson));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)))
                .andExpect(jsonPath("$.title", is("Spring Security 1")))
                ;
    }

    @Test
    @Transactional
    @Rollback
    public void testCreateLesson2() throws Exception{
        Lesson lesson = new Lesson();

        lesson.setTitle("Spring Security 2");
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(lesson));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)))
                .andExpect(jsonPath("$.title", is("Spring Security 2")))
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testGetLesson1a() throws Exception{
        Lesson lesson = new Lesson();

        lesson.setTitle("Spring Security 1");
        repository.save(lesson);
        lesson.setTitle("Spring Security 2");
        repository.save(lesson);
        lesson.setTitle("Spring Security 3");
        repository.save(lesson);

        for (Lesson lessonTmp : repository.findAll()) {
            lesson=lessonTmp;
            break;
        }

        this.mvc.perform(get("/lessons/" + lesson.getId().toString())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(lesson.getId().intValue())))
                .andExpect(jsonPath("$.title", is(lesson.getTitle())))
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testGetLesson1b() throws Exception{
        Lesson lesson = new Lesson();
        int count=0;

        lesson.setTitle("Spring Security 1");
        repository.save(lesson);
        lesson.setTitle("Spring Security 2");
        repository.save(lesson);
        lesson.setTitle("Spring Security 3");
        repository.save(lesson);

        for (Lesson lessonTmp : repository.findAll()) {
            lesson=lessonTmp;
            count+=1;
        }

        this.mvc.perform(get("/lessons/")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[" + (count-1) + "].id", is(lesson.getId().intValue())))
                .andExpect(jsonPath("$[" + (count-1) + "].title", is(lesson.getTitle())))
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateLesson1() throws Exception{
        Lesson lesson = new Lesson();

        lesson.setTitle("Spring Security 1");
        repository.save(lesson);
        lesson.setTitle("Spring Security 2");
        repository.save(lesson);
        lesson.setTitle("Spring Security 3");
        repository.save(lesson);

        for (Lesson lessonTmp : repository.findAll()) {
            lesson=lessonTmp;
        }

        lesson.setTitle(lesson.getTitle() + " UPD");

        MockHttpServletRequestBuilder request = patch("/lessons/" + lesson.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(lesson));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(lesson.getId().intValue())))
                .andExpect(jsonPath("$.title", is("Spring Security 3 UPD")))
        ;
    }
}
