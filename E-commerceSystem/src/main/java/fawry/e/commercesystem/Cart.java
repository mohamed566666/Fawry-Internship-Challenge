/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawry.e.commercesystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mohamed
 */
public class Cart {

    private Map<Product, Integer> products;

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Cart() {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Can't Add Product " + product.getName() + " with quantity " + quantity + "because quantity must be positive and more than zero");
            System.out.println("Add Failed");
            return;
        }
        if (quantity > product.getQuantity()) {
            System.out.println("Can't Add Product " + product.getName() + " with quantity " + quantity + " more than its available quantity in Stock");
            System.out.println("Add Failed");
            return;
        }
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
        product.decreaseQuantity(quantity);
    }

    public void clear() {
        products.clear();
    }

    public void clearAndReturnToStock() {
        for (var product : products.keySet()) {
            product.increaseQuantity(products.get(product));
        }
        products.clear();
    }
}
