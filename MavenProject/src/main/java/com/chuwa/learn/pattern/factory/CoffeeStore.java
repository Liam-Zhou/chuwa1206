package com.chuwa.learn.pattern.factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee("american");

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
