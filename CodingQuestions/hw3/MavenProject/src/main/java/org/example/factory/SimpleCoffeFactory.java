package org.example.factory;

import org.example.factory.AmericanCoffee;
import org.example.factory.Coffee;
import org.example.factory.LatteCoffee;

public class SimpleCoffeFactory {
    public Coffee createCoffee(String type) {
        Coffee coffee = null;
        if("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Coffee type not exist");
        }

        return coffee;
    }
}
