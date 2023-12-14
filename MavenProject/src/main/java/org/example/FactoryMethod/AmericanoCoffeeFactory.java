package org.example.FactoryMethod;

import org.example.SimpleFactory.AmericanoCoffee;
import org.example.SimpleFactory.Coffee;

public class AmericanoCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new AmericanoCoffee();
    }
}
