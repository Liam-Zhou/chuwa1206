package org.example.FactoryMethod;

import org.example.SimpleFactory.Coffee;

public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();
        System.out.println(coffee.getType());
        return coffee;
    }
}

// client can implement their own coffeefactory
