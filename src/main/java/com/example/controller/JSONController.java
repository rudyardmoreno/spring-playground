package com.example.controller;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * JSON Controller
 */

import com.example.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



@RestController
public class JSONController {

    public Flight getFlight(String departs, String firstName, String lastName, int price) throws Exception {
        Passenger passenger = new Passenger();
        List<Ticket> tickets = new ArrayList<Ticket>();
        Ticket ticket = new Ticket();
        Flight flight = new Flight();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);

        ticket.setPassenger(passenger);
        ticket.setPrice(price);

        tickets.add(ticket);

        flight.setDeparts(df.parse(departs));
        flight.setTickets(tickets);

        return flight;
    }

    @GetMapping("/flights/flight")
    public Flight getMapFlight() throws Exception {
        return getFlight("2017-04-21 14:34","Some name","Some other name",200);
    }

    @GetMapping("/flights")
    public List<Flight> getMapFlights() throws Exception {
        List<Flight> flights = new ArrayList<Flight>();
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();

        flight1=getFlight("2017-04-21 14:34","Some name","Some other name",200);
        flight2=getFlight("2017-04-21 14:34","Some other name",null,400);

        flights.add(flight1);
        flights.add(flight2);

        return flights;
    }

    @PostMapping("/flights/tickets/total")
    public Result getTicketsTotal(@RequestBody Tickets tickets) throws Exception {
        Result result = new Result();
        int totalResult=0;

        for (Ticket2 ticket : tickets.getTickets()) {
            totalResult+=ticket.getPrice();
        }

        result.setResult(totalResult);
        return result;
    }
}
