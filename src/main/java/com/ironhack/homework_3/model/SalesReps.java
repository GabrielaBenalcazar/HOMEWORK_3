package com.ironhack.homework_3.model;

import javax.persistence.*;
import java.util.Set;

@Entity

public class SalesReps {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = AUTO_INCREMENT
    private int id ;
    private String name;
    @OneToMany
    private Set<Lead> leads;

    @OneToMany
    private Set<Opportunity> opportunities;


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
