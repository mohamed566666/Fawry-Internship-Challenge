/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fawry.e.commercesystem;

import java.time.LocalDate;

/**
 *
 * @author Mohamed
 */
public class ECommerceSystem {

    public static void main(String[] args) {
        
        /*
        my Assumptions here, if there is an error in adding any product,
        this product will not be added and a phrase will appear to the user indicating that
        an error occurred while keeping the shopping cart as it is
        
        If the customer's balance is not enough, all products will be returned to the stock
        
        During Checkout... if there is an expired product , 
        the error will be reported and this product will be completely ignored and returned to the Stock again,
        and the payment process will be completed with the rest of the products in the cart
        
        */

        Product cheese = new Product("cheese", 100.00d, 50, 200.00, LocalDate.of(2025, 8, 6));
        Product Biscuits = new Product("Biscuits", 150.00d, 50, 700.00, LocalDate.of(2025, 12, 25));
        Cart cart = new Cart();
        Customer custoer = new Customer("Mohamed", 50000.00);

        cart.add(cheese, 2);
        cart.add(Biscuits, 1);
        CheckoutService.checkout(custoer, cart);

        /*
        Receipt with no shipping
        
        Product tv = new Product("tv" , 3000.00d , 10 , null , null);
        Customer custoer2 = new Customer("Ahmed" , 50000.00);
        cart.add(tv, 3);
        CheckoutService.checkout(custoer2, cart);
         */
        
        /*
        //Receipt with Insufficient balance
        
        Product joice = new Product("joice" , 50.00d , 10 , 250.0 , LocalDate.of(2026, 10, 25));
        Customer custoer3 = new Customer("Ali" , 100.00);
        cart.add(joice, 3);
        CheckoutService.checkout(custoer3, cart);
        */
 
        /*
        //Receipt with Expired Product        
        Product Chips = new Product("Chips" , 5.00d , 10 , 250.0 , LocalDate.of(2024, 10, 25)); // ُExpired
        Customer custoer4 = new Customer("Kareem" , 500.00);
        cart.add(Chips, 3); // fail
        cart.add(cheese, 1);
        CheckoutService.checkout(custoer4, cart);
        */
 
         /*
        Error if we try to add quantity more than quantity in stock
        
        Product mobile = new Product("mobile" , 3500.00d , 2 , null , null);
        Customer custoer5 = new Customer("Shady" , 5000.00);
        cart.add(mobile, 3);
        CheckoutService.checkout(custoer5, cart);
         */
 
        /*
        Error if we try to add negative quantity
        Product mobile = new Product("tablet" , 3000.00d , 3 , null , null);
        Customer custoer6 = new Customer("Eyad" , 5000.00);
        cart.add(mobile, 1);
        cart.add(mobile, -1);
        CheckoutService.checkout(custoer6, cart);
        */
         
    }
}
