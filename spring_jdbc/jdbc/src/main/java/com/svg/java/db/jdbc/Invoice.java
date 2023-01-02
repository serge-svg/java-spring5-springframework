package com.svg.java.db.jdbc;

import lombok.Data;

@Data
public class Invoice {
    private int number;
    private String concept;
    private double amount;

    public Invoice() {
    }

    public Invoice(int number, String concept, double amount) {
        this.number = number;
        this.concept = concept;
        this.amount = amount;
    }

}