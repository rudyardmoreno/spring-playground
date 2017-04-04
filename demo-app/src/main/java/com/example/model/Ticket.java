package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Ticket Class
 */
public class Ticket {
    //Properties
    private Passenger passenger;
    private int price;

    //Getters
    @JsonProperty("Passenger")
    public Passenger getPassenger() { return passenger; }
    @JsonProperty("Price")
    public int getPrice() { return price; }

    //Setters
    public void setPassenger(Passenger value) { passenger=value; }
    public void setPrice(int value) { price=value; }

    //Constructor
    public Ticket() {
        setPassenger(new Passenger());
        setPrice(0);
    }
}
