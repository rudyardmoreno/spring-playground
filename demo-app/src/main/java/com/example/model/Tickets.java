package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Tickets Class
 */
public class Tickets {
    //Properties
    private List<Ticket2> tickets;

    //Getters
    public List<Ticket2> getTickets() { return tickets; }

    //Setters
    public void setTickets(List<Ticket2> value) { tickets=value; }

    //Constructor
    public Tickets() {
        setTickets(new ArrayList<Ticket2>());
    }
}
