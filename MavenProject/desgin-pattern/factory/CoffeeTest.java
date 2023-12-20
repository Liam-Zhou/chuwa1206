package com.java.factory;

import java.util.Collections;

public class CoffeeTest {
    public static void main(String[] args){
        CoffeeStore store=new CoffeeStore();

        Coffee coffee=store.orderCoffee("Latte");

        System.out.println(coffee.getName());
    }
}
