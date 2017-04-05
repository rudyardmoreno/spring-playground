package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 3 - Request and Responses
 * Model - Flight Class
 */
public class Flight {
    //Properties
    private Date departs;
    private List<Ticket> tickets;

    //Getters
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="America/Denver")
    @JsonProperty("Departs")
    public Date getDeparts() { return departs; }
    @JsonProperty("Tickets")
    public List<Ticket> getTickets() { return tickets; }

    //Setters
    public void setDeparts(Date value) { departs=value; }
    public void setTickets(List<Ticket> value) { tickets=value; }

    //Constructor
    public Flight() {
        setDeparts(new Date());
        setTickets(new ArrayList<Ticket>());
    }

}
