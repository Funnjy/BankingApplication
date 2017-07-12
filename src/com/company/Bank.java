package com.company;

import java.util.ArrayList;

/**
 * Created by Anton Ilchenko on 11.07.2017.
 */
public class Bank {
    private String bankName;
    private ArrayList<Branches> branches = new ArrayList<Branches>();

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branches>();
    }

    public boolean addBranch(String branchName) {
        if (findeBranch(branchName) == null) {
            this.branches.add(new Branches(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branches branch = findeBranch(branchName);
        if (branch != null) {
            return branch.addCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branches branch = findeBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }


    private Branches findeBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branches checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean showTransactions) {
        Branches branch = findeBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomerList();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + " [" + (i + 1) + "] ");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}


