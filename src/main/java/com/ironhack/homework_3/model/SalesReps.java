package com.ironhack.homework_3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class SalesReps {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = AUTO_INCREMENT
    private int id ;
    private String name;



    //Constructor

    public SalesReps() {

    }

    public SalesReps(String name) {
        this.name = name;
    }

    // Setters-getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // to string

    @Override
    public String toString() {
        return "SalesReps{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
