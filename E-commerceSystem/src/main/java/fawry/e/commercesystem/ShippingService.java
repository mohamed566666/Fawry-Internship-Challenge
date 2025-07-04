/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fawry.e.commercesystem;

import java.util.Map;

/**
 *
 * @author Mohamed
 */
public class ShippingService {
    private final static double shippingFeesPerKG = 27.00d;
    public static double ship(Map<Shippable, Integer> products){
        double TotalWeightPerKG = 0.00;
        if (products.isEmpty()){
            return 0.00;
        }
        System.out.println("** Shipment notice **");
        for (var product : products.keySet()){
            System.out.println(products.get(product) + "X " + product.getName() + "     " + product.getWeight() * products.get(product) + "g");
            TotalWeightPerKG += (product.getWeight() * products.get(product)) / 1000.00;
        }
        System.out.println("Total package weight " + TotalWeightPerKG + "kg\n");
        return (shippingFeesPerKG * TotalWeightPerKG );
    }
}
