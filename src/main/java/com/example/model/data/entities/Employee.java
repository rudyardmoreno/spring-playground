package com.example.model.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 8 - Spring Security
 * Model - Employee
 */

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int salary;
    private long managerId;

    public Long getId() {
        return id;
    }
    public String getName() { return name;}
    @JsonIgnore
    public int getSalary() {
        return salary;
    }
    public long getManagerId() { return managerId; }

    public void setId(Long value) {id = value;}
    public void setName(String value) {
        name = value;
    }
    public void setSalary(int value) { salary=value; }
    public void setManagerId(long value) { managerId=value; }
}
