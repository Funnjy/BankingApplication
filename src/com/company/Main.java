package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("DNB");
        bank.addBranch("Oslo");

        bank.addCustomer("Oslo", "Anton", 1330.30);
        bank.addCustomer("Oslo", "Carl", 6000.50);
        bank.addCustomer("Oslo", "Walter", 50.00);

        bank.addBranch("Halden");
        bank.addCustomer("Halden", "Liubov", 10.50);

        bank.listCustomer("Halden", true);

//         bank.addBranch("Fredrikstad");
        if (!bank.addCustomer("Fredrikstad", "Bob", 55.34)) {
            System.out.println("Error Fredrikstad does not exist");
        }
        if (!bank.addCustomerTransaction("Oslo", "George", 750.00)) {
            System.out.println("Customer George does not exist");
        }
        if (!bank.addCustomer("Oslo", "Anton", 231635.33)) {
            System.out.println("Customer Anton already exists");
        }
    }
}
