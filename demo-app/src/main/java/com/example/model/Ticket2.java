package com.example.model;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Ticket2 Class
 */
public class Ticket2 {
    //Properties
    private Passenger2 passenger;
    private int price;

    //Getters
    public Passenger2 getPassenger() { return passenger; }
    public int getPrice() { return price; }

    //Setters
    public void setPassenger(Passenger2 value) { passenger=value; }
    public void setPrice(int value) { price=value; }

    //Constructor
    public Ticket2() {
        setPassenger(new Passenger2());
        setPrice(0);
    }
}
