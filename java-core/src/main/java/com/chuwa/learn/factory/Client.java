package com.chuwa.learn.factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.oderCoffee("american");
        System.out.println(coffee.getName());
    }
}
