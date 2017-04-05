package com.example.model;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Result Class
 */
public class Result {
    //Properties
    private int result;

    //Getters
    public int getResult() { return result; }

    //Setters
    public void setResult(int value) { result=value; }

    //Constructor
    public Result() {
        setResult(0);
    }
}
