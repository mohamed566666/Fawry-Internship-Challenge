/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawry.e.commercesystem;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Mohamed
 */
public class Product implements Shippable {

    private String name;
    private double price;
    private int quantity;
    private Double weight;
    private LocalDate expiryDate;

    public Product(String name, Double price, int quantity, Double weight, LocalDate expiryDate) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setWeight(weight);
        setExpiryDate(expiryDate);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name can't be null or empty");
        }
        this.name = name;
    }

    @Override
    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        if (weight != null && weight < 0) {
            throw new IllegalArgumentException("Weight can't be negative");
        }
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Price can't be Negative or NULL");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative");
        }
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void decreaseQuantity(int val) {
        if (val < 0) {
            throw new IllegalArgumentException("Decrement value cannot be negative");
        }
        if (val > this.quantity) {
            throw new IllegalArgumentException("Not enough quantity in stock to decrease by " + val);
        }
        this.quantity -= val;
    }

    public void increaseQuantity(int val) {
        if (val < 0) {
            throw new IllegalArgumentException("Increment value cannot be negative");
        }
        this.quantity += val;
    }

    public boolean isShipping() {
        return this.weight != null;
    }

    public boolean isExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
