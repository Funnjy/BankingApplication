package com.company;

import java.util.ArrayList;

/**
 * Created by Anton Ilchenko on 11.07.2017.
 */
public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmaunt) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmaunt);
    }

    public void addTransaction(double amaunt) {
        this.transactions.add(amaunt);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getDoubles() {
        return transactions;
    }

    public String toString(){
        return "Customer name: " + getName();
     }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
