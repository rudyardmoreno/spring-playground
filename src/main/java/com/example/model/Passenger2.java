package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Passenger2 Class
 */
public class Passenger2 {
    //Properties
    private String firstName;
    private String lastName;

    //Getters
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFirstName() { return firstName; }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLastName() { return lastName; }

    //Setters
    public void setFirstName(String value) { firstName=value; }
    public void setLastName(String value) { lastName=value; }

    //Constructor
    public Passenger2() {
        setFirstName("");
        setLastName("");
    }
}
