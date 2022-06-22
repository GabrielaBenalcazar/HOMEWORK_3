package com.ironhack.homework_3.model;

import com.ironhack.homework_3.enums.Industry;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class Account {

            //

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = AUTO_INCREMENT
    private int id ;
    private String companyName;
    @Enumerated(value = EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;

    @OneToMany(mappedBy = "account")
    private Set<Contact> contactList;
    @OneToMany(mappedBy = "account")
    private Set<Opportunity> opportunityList;

    // Constructor


    public Account( String companyName, Industry industry, int employeeCount, String city, String country, Set<Contact> contactList, Set<Opportunity> opportunityList) {

        this.companyName = companyName;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    public Account() {

    }



    // Methods

    public void addContactToList(Contact contact) {
        contactList.add(contact);
    }

    public void addOpportunityToList(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(Set<Contact> contactList) {
        this.contactList = contactList;
    }

    public Set<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(Set<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    //to string

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                '}';
    }
}

