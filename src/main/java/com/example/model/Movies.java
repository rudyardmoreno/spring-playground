package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudyard Moreno on 4/17/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 7 - RestTemplates
 */
public class Movies {
    //Properties
    @JsonProperty("Search")
    private List<Titles> search;
    private int totalResults;
    @JsonProperty("Response")
    private boolean response;
    @JsonProperty("Error")
    private String error;

    //Getters
    public List<Titles> getSearch() { return search; }
    public int getTotalResults() { return totalResults; }
    public boolean getResponse() { return response; }
    public boolean isResponse() { return response; }
    public String getError() { return error; }

    //Setters
    public void setSearch(List<Titles> value) { search=value;}
    public void setTotalResults(int value) { totalResults=value; }
    public void setResponse(boolean value) { response=value; }
    public void setError(String value) { error=value; }

    //Constructor
    public Movies() {
        setSearch(new ArrayList<Titles>());
        setTotalResults(0);
        setResponse(false);
        setError("");
    }

}
