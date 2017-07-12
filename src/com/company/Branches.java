package com.company;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;

/**
 * Created by Anton Ilchenko on 11.07.2017.
 */
public class Branches {
    private String name;
    private ArrayList<Customer> customerList;

    public Branches(String name) {
        this.name = name;
        this.customerList = new ArrayList<Customer>();
    }

    public boolean addCustomer(String customerName, double initialAmount) {
        if (findeCustomer(customerName) == null) {
            this.customerList.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findeCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findeCustomer(String customerName) {
        for (int i = 0; i < this.customerList.size(); i++) {
            Customer checkdCustomer = this.customerList.get(i);
            if (checkdCustomer.getName().equals(customerName)) {
                return checkdCustomer;
            }
        }
        return null;
    }


    public String getName() {
        return name;
   }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
