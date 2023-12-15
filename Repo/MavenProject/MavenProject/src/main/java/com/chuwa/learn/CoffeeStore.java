package com.chuwa.learn;

import com.chuwa.learn.simple_factory.AmericanCoffee;
import com.chuwa.learn.simple_factory.Coffee;
import com.chuwa.learn.simple_factory.SimpleCoffeeFactory;

public class CoffeeStore {

    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = coffeeFactory.createCoffee("american");
        coffee.addmilk();
        return coffee;
    }

}
