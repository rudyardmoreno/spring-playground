package com.example;

/*
 * Created by Rudyard Moreno on 04/05/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Users Controller
 */

import com.example.model.CUser;
import com.example.model.User;
import com.example.model.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserRepository repository;

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

    public UsersController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public CUsers all() {
        CUsers cusers = new CUsers();
        cusers.setUsers(this.repository.findAll());
        return cusers;
    }

    @GetMapping("/{id}")
    public CUser getOne(@PathVariable Long id) {
        CUser cuser = new CUser();
        cuser.setUser(this.repository.findOne(id));
        return cuser;
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User userResult = new User();
        user.setId(id);

        if (user.getPassword() == null) {
            user.setPassword(this.repository.findOne(id).getPassword());
        } else {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        }

        userResult=this.repository.save(user);
        return userResult;
    }

    @DeleteMapping("/{id}")
    public CCount delete(@PathVariable Long id) {
        CCount cCount = new CCount();
        int count=0;
        this.repository.delete(id);
        for (User user : this.repository.findAll()){
            count+=1;
        }
        cCount.setCount(count);
        return cCount;
    }

    @PostMapping("")
    public User create(@RequestBody CUser cuser) {
        User user=new User();
        if (cuser.getUser().getPassword() != null) {
            cuser.getUser().setPassword(DigestUtils.md5DigestAsHex(cuser.getUser().getPassword().getBytes()));
        }
        user=this.repository.save(cuser.getUser());
        return user;
    }

    @PostMapping("/authenticate")
    public CAuthenticated getAuthenticate(@RequestBody User user) {
        CAuthenticated authenticated= new CAuthenticated();

        try {
            for (User userTmp : this.repository.findAll()) {
                if (userTmp.getEmail().equals(user.getEmail())) {
                    if (userTmp.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))) {
                        authenticated.setAuthenticated(true);
                        authenticated.setUser(userTmp);
                    }
                }
            }
        } catch (Exception e) {
            //Nothing
        }

        return authenticated;
    }
}
