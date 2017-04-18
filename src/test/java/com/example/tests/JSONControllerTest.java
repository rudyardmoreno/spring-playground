package com.example.tests;

import com.example.controller.JSONController;
import com.example.model.Passenger2;
import com.example.model.Ticket2;
import com.example.model.Tickets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import com.google.gson.JsonObject;

/*
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test JSON Controller
 */

@RunWith(SpringRunner.class)
@WebMvcTest(JSONController.class)
@AutoConfigureMockMvc(secure=false)
public class JSONControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testFlight() throws Exception{
        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("Some name")))
                .andExpect(jsonPath("$.Tickets[0].Passenger.LastName", is("Some other name")))
                .andExpect(jsonPath("$.Tickets[0].Price", is(200)))
                ;
    }

    @Test
    public void testFlights() throws Exception{
        this.mvc.perform(
                get("/flights")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].Departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$[0].Tickets[0].Passenger.FirstName", is("Some name")))
                .andExpect(jsonPath("$[0].Tickets[0].Passenger.LastName", is("Some other name")))
                .andExpect(jsonPath("$[0].Tickets[0].Price", is(200)))
                .andExpect(jsonPath("$[1].Departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$[1].Tickets[0].Passenger.FirstName", is("Some other name")))
                .andExpect(jsonPath("$[1].Tickets[0].Price", is(400)))
        ;
    }

    private Gson gson = new GsonBuilder().create();

    @Test
    public void testFlightTicketsTotal1() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"tickets\": [\n" +
                        "    {\n" +
                        "      \"passenger\": {\n" +
                        "        \"firstName\": \"Some name\",\n" +
                        "        \"lastName\": \"Some other name\"\n" +
                        "      },\n" +
                        "      \"price\": 200\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"passenger\": {\n" +
                        "        \"firstName\": \"Name B\",\n" +
                        "        \"lastName\": \"Name C\"\n" +
                        "      },\n" +
                        "      \"price\": 150\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));
    }

    @Test
    public void testFlightTicketsTotal2() throws Exception {

        ArrayList<Ticket2> ticketLst = new ArrayList<Ticket2>();
        Tickets tickets = new Tickets();

        //Set Ticket 1
        Ticket2 ticket1 = new Ticket2();
        Passenger2 passengerA = new Passenger2();
        passengerA.setFirstName("Some name");
        passengerA.setLastName("Some other name");
        ticket1.setPassenger(passengerA);
        ticket1.setPrice(200);

        //Set Ticket 2
        Ticket2 ticket2 = new Ticket2();
        Passenger2 passengerB = new Passenger2();
        passengerB.setFirstName("Name B");
        passengerB.setLastName("Name C");
        ticket2.setPassenger(passengerB);
        ticket2.setPrice(150);

        ticketLst.add(ticket1);
        ticketLst.add(ticket2);
        tickets.setTickets(ticketLst);

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(tickets));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));
    }

    @Test
    public void testFlightTicketsTotal3() throws Exception{
        String jsonRequest = getJSON("/flightTicketsDataRequest.json");

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
