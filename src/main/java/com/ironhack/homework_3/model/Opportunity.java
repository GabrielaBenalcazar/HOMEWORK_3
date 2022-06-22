package com.ironhack.homework_3.model;


import com.ironhack.homework_3.enums.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Opportunity {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = AUTO_INCREMENT
    private int id;

    @Enumerated(value = EnumType.STRING)
    private Product product;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "decision_maker_id")
    private Contact decisionMaker;
    @ManyToOne
    @JoinColumn(name = "sales_reps_id")
    private SalesReps salesReps;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;




    //Constructor

    public Opportunity(Product product, int quantity, Contact decisionMaker, SalesReps salesReps, Status status) {

        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.salesReps = salesReps;
        this.status = status;
    }


    public Opportunity() {
    }

    // Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return quantity == that.quantity && product == that.product && Objects.equals(decisionMaker, that.decisionMaker) && status == that.status;
    }

    // Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("The number of trucks must be greater than zero.");
        }
        this.quantity = quantity;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //Getters

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Contact getDecisionMaker() {
        return this.decisionMaker;
    }

    public Status getStatus() {
        return status;
    }
    public SalesReps getSalesReps() {
        return salesReps;
    }

    public void setSalesReps(SalesReps salesReps) {
        this.salesReps = salesReps;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getOpportunityInfo() {
        return "Product: " + this.product + ". Quantity: " + this.quantity + ". STATUS: " + this.status;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", decisionMaker=" + decisionMaker +
                ", status=" + status +
                '}';
    }

}
