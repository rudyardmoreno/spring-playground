package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Rudyard Moreno on 4/17/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 7 - RestTemplates
 * Titles class
 */
public class Titles {
    //Properties
    private String title;
    private String imdbId;
    private String poster;
    private String year;
    private String type;

    //Getters
    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("imdbId")
    public String getImdbId() { return imdbId; }
    @JsonProperty("poster")
    public String getPoster() { return poster; }
    @JsonProperty("year")
    public String getYear() { return year; }
    @JsonIgnore
    @JsonProperty("type")
    public String getType() { return type; }

    //Setters
    @JsonProperty("Title")
    public void setTitle(String value) { title=value; }
    @JsonProperty("imdbID")
    public void setImdbId(String value) { imdbId=value; }
    @JsonProperty("Poster")
    public void setPoster(String value) { poster=value; }
    @JsonProperty("Year")
    public void setYear(String value) { year=value; }
    @JsonProperty("Type")
    public void setType(String value) { type=value; }

    //Constructor
    public Titles() {
        setTitle("");
        setImdbId("");
        setPoster("");
        setYear("");
        setType("");
    }

}
