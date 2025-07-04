/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawry.e.commercesystem;

/**
 *
 * @author Mohamed
 */
public class Customer {

    private String name;
    private double balance;

    public Customer(String name, double balance) {
        setName(name);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name can't be null or empty");
        }
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be non negative");
        }
        this.balance = balance;
    }

    public boolean canPay(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non negative");
        }
        return (this.balance >= amount);
    }

    public void pay(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non negative");
        }
        if (!canPay(amount)) {
            throw new IllegalArgumentException("Insufficient balance to pay " + amount);
        }
        this.balance -= amount;
    }

}
