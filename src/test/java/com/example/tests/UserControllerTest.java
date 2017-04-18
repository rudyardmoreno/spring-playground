package com.example.tests;

/*
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test JSON Controller
 */

import com.example.model.CUser;
import com.example.model.data.entities.User;
import com.example.model.data.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
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
import org.springframework.util.DigestUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(secure=false)
public class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    UserRepository repository;

    private class CUsers {
        private Iterable<User> users;
        public Iterable<User> getUsers() { return users;}
        public void setUsers(Iterable<User> value) { users=value;}
        public CUsers() {
            setUsers(new ArrayList<User>());
        }
    }

    private class CCount {
        private int count;
        public int getCount() { return count; }
        public void setCount(int value) { count=value;}
        public CCount() { setCount(0); }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class CAuthenticated {
        private boolean authenticated;
        private User user;
        public boolean isAuthenticated() { return authenticated; }
        public User getUser() { return user; }
        public void setAuthenticated(boolean value) {authenticated=value; }
        public void setUser(User value) { user=value;}
        public CAuthenticated() {
            setAuthenticated(false);
        }
    }

    private Gson gson = new GsonBuilder().create();

    @Test
    @Transactional
    @Rollback
    public void testCreateUser1() throws Exception{
        User user = new User();
        CUser cuser = new CUser();

        user.setEmail("john@example.com");
        cuser.setUser(user);

        MockHttpServletRequestBuilder request = post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(cuser));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)))
                .andExpect(jsonPath("$.email", is("john@example.com")))
                .andExpect(jsonPath("$.password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testCreateUser2() throws Exception{
        User user = new User();
        CUser cuser = new CUser();

        user.setEmail("john@example.com");
        user.setPassword("1234");
        cuser.setUser(user);

        MockHttpServletRequestBuilder request = post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(cuser));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)))
                .andExpect(jsonPath("$.email", is("john@example.com")))
                .andExpect(jsonPath("$.password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testGetUsers1() throws Exception{
        User user = new User();

        user.setEmail("john@example.com");
        this.repository.save(user);

        MockHttpServletRequestBuilder request = get("/users")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users[0].id", instanceOf(Number.class)))
                .andExpect(jsonPath("$.users[0].email", is("john@example.com")))
                .andExpect(jsonPath("$.users[0].password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testGetUsers2() throws Exception{
        User user = new User();

        user.setEmail("john@example.com");
        user=this.repository.save(user);

        MockHttpServletRequestBuilder request = get("/users/" + user.getId().toString())
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.id", is(user.getId().intValue())))
                .andExpect(jsonPath("$.user.email", is("john@example.com")))
                .andExpect(jsonPath("$.user.password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testPatchUser1() throws Exception{
        User user = new User();

        user.setEmail("john@example.com");
        user.setPassword("hola123");
        user= this.repository.save(user);

        MockHttpServletRequestBuilder request = patch("/users/" + user.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user.getId().intValue())))
                .andExpect(jsonPath("$.email", is("john@example.com")))
                .andExpect(jsonPath("$.password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testPatchUser2() throws Exception{
        User user = new User();

        user.setEmail("john@example.com");
        user= this.repository.save(user);

        MockHttpServletRequestBuilder request = patch("/users/" + user.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user.getId().intValue())))
                .andExpect(jsonPath("$.email", is("john@example.com")))
                .andExpect(jsonPath("$.password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteUser1() throws Exception{
        User user = new User();

        user.setEmail("john@example.com");
        user.setPassword("hola123");
        user= this.repository.save(user);

        MockHttpServletRequestBuilder request = delete("/users/" + user.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0)))
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteUser2() throws Exception{
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setEmail("john@example.com");
        user1.setPassword("hola123");
        user1=this.repository.save(user1);

        user2.setEmail("peter@example.com");
        user2.setPassword("1234");
        user2=this.repository.save(user2);

        user3.setEmail("ana@example.com");
        user3.setPassword("sdasd");
        user3=this.repository.save(user3);

        MockHttpServletRequestBuilder request = delete("/users/" + user1.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user1));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(2)))
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testAuthenticateUser1() throws Exception{
        User user = new User();
        User userReq = new User();

        //Create user on DB
        user.setEmail("john@example.com");
        user.setPassword("hola123");
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user= this.repository.save(user);

        //Request - Authenticate user
        userReq.setEmail("john@example.com");
        userReq.setPassword("hola123");

        MockHttpServletRequestBuilder request = post("/users/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userReq));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.authenticated", is(true)))
                .andExpect(jsonPath("$.user.id", is(user.getId().intValue())))
                .andExpect(jsonPath("$.user.email", is("john@example.com")))
                .andExpect(jsonPath("$.user.password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testAuthenticateUser2() throws Exception{
        User user = new User();
        User userReq = new User();

        user.setEmail("john@example.com");
        user.setPassword("hola123");
        user= this.repository.save(user);

        userReq.setEmail("john@example.com");
        userReq.setPassword("Adios123");

        MockHttpServletRequestBuilder request = post("/users/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userReq));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.authenticated", is(false)))
                .andExpect(jsonPath("$.user.id").doesNotExist())
                .andExpect(jsonPath("$.user.email").doesNotExist())
                .andExpect(jsonPath("$.user.password").doesNotExist())
        ;
    }

    @Test
    @Transactional
    @Rollback
    public void testAuthenticateUser3() throws Exception{
        User user = new User();

        user.setEmail("peter@example.com");
        user.setPassword("Adios123");

        MockHttpServletRequestBuilder request = post("/users/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.authenticated", is(false)))
                .andExpect(jsonPath("$.user.id").doesNotExist())
                .andExpect(jsonPath("$.user.email").doesNotExist())
                .andExpect(jsonPath("$.user.password").doesNotExist())
        ;
    }
}
