/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawry.e.commercesystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Mohamed
 */
public class CheckoutService {

    public static double calculateSubTotal(Map<Product, Integer> products) {
        double subTotal = 0.00d;
        for (var product : products.keySet()) {
            subTotal += products.get(product) * product.getPrice();
        }
        return subTotal;
    }

    public static void removeExpiredProductsAndReturnToStock(Map<Product, Integer> products) {
        Iterator<Product> iterator = products.keySet().iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.isExpired()) {
                System.out.println("ERROR , This Product " + product.getName() + " is Expired");
                product.increaseQuantity(products.get(product));
                iterator.remove();
                System.out.println("Product " + product.getName() + " back to Stock");
            }
        }
    }

    public static Map<Shippable, Integer> getShippableProducts(Map<Product, Integer> products) {
        Map<Shippable, Integer> shippableProducts = new HashMap<>();
        for (var product : products.keySet()) {
            if (product.isShipping()) {
                shippableProducts.put(product, products.get(product));
            }
        }
        return shippableProducts;
    }

    public static void printReceipt(Map<Product, Integer> products, double subTotal, double shippingFees, Customer customer) {
        System.out.println("** Checkout receipt **");
        for (var product : products.keySet()) {
            System.out.println(products.get(product) + "X " + product.getName() + "     " + products.get(product) * product.getPrice());
        }
        System.out.println("------------------------------");
        System.out.println("Subtotal     " + subTotal);
        System.out.println("Shipping     " + shippingFees);
        System.out.println("Amount       " + (subTotal + shippingFees));
        System.out.println("Customer current balance    " + customer.getBalance() + "\n");
    }

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("ERROR , Cart is empty , Nothing to checkout");
            return;
        }

        Map<Product, Integer> products = cart.getProducts();

        removeExpiredProductsAndReturnToStock(products);
        
        if (products.isEmpty()) {
            System.out.println("ERROR , Cart is empty now , Nothing to checkout");
            return;
        }

        Map<Shippable, Integer> shippableProducts = getShippableProducts(products);

        double shippingFees = ShippingService.ship(shippableProducts);

        double subTotal = calculateSubTotal(products);

        if (!customer.canPay(subTotal + shippingFees)) {
            System.out.println("ERROR  , Customer balance is insucient");
            cart.clearAndReturnToStock();
            System.out.println("Products back to Stock");
            return;
        }
        customer.pay((subTotal + shippingFees));
        printReceipt(products, subTotal, shippingFees, customer);
        cart.clear();
    }

}
