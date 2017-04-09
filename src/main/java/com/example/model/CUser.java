package com.example.model;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 5 - Building CRUD APIs
 * Model - CUser
 */

public class CUser {
    private User user;
    public User getUser() { return user;}
    public void setUser(User value) { user=value;}
    public CUser(){
        setUser(new User());
    }
}
