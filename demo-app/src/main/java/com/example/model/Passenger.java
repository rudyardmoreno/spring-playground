package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Passenger Class
 */
public class Passenger {
    //Properties
    private String firstName;
    private String lastName;

    //Getters
    @JsonProperty("FirstName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFirstName() { return firstName; }
    @JsonProperty("LastName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLastName() { return lastName; }

    //Setters
    public void setFirstName(String value) { firstName=value; }
    public void setLastName(String value) { lastName=value; }

    //Constructor
    public Passenger() {
        setFirstName("");
        setLastName("");
    }
}
