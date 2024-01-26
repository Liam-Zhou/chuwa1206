package com.chuwa.learn.pattern.factory;

public class FactoryTest {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());

        coffee = store.orderCoffee("american");
        coffee.addMilk();

        coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());
    }
}