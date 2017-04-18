package com.example.tests;

/*
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test RestTemplateControllerTests
 */

import com.example.model.Movies;
import com.example.service.MoviesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(secure = false)
public class RestTemplateControllerTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    MoviesService service;

    @Test
    public void test1() throws Exception {
        assertThat(service.getMovies("harry").getTotalResults(),instanceOf(Number.class));
    }

    @Test
    public void test2() throws Exception {

        this.mvc.perform(get("/movies?q=harry")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Harry Potter and the Deathly Hallows: Part 2")))
                .andExpect(jsonPath("$[0].imdbId",is("tt1201607")))
                .andExpect(jsonPath("$[0].year", is("2011")))

        ;
    }

    @Test
    public void getMoviesRequestWorks() throws Exception{
        MockRestServiceServer mockServer=MockRestServiceServer.createServer(service.getRestTemplate());
        String jsonRequest = getJSON("/RestTemplateControllerRequest1.json");
        Movies movies = new Movies();

        mockServer
                .expect(requestTo("http://www.omdbapi.com/?s=harry"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(jsonRequest, MediaType.APPLICATION_JSON));

        movies= service.getMovies("harry");

        assertThat(movies.getTotalResults(),equalTo(2));
        assertThat(movies.isResponse(),equalTo(true));

        assertThat(movies.getSearch().get(0).getTitle(),equalTo("Harry Potter and the Deathly Hallows: Part 2"));
        assertThat(movies.getSearch().get(0).getImdbId(),equalTo("tt1201607"));
        assertThat(movies.getSearch().get(0).getType(),equalTo("movie"));
        assertThat(movies.getSearch().get(0).getYear(),equalTo("2011"));

        assertThat(movies.getSearch().get(1).getTitle(),equalTo("Harry Potter and the Sorcerer's Stone"));
        assertThat(movies.getSearch().get(1).getImdbId(),equalTo("tt0241527"));
        assertThat(movies.getSearch().get(1).getType(),equalTo("movie"));
        assertThat(movies.getSearch().get(1).getYear(),equalTo("2001"));

        mockServer.verify();
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
