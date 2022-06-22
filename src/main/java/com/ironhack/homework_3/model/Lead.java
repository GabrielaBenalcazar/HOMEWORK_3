package com.ironhack.homework_3.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Lead  {

    // Properties

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = AUTO_INCREMENT
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "sales_reps_id")
    private SalesReps salesReps;




    // Constructor


    public Lead( String name, String phoneNumber, String email, String companyName, SalesReps salesReps) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.salesReps = salesReps;
    }

    public Lead() {

    }

//Methods

//    public static void removeItem(Lead lead) {
//        for (int i = 0; i < allLeads.size(); i++) {
//            if (lead.equals(allLeads.get(i))) {
//                allLeads.remove(i);
//            }
//        }
//    }

    // Getters and setters

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        try {
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            boolean matchFound = m.matches();
            if (matchFound) {
                this.email = email;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Wrong email address");
        }
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public SalesReps getSalesReps() {
        return salesReps;
    }

    public void setSalesReps(SalesReps salesReps) {
        this.salesReps = salesReps;
    }


    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
