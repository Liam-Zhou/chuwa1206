package com.chuwa.learn;

import com.chuwa.learn.simple_factory.Coffee;

public class Client2 {
    public static void main(String[] args){
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("american");
        System.out.println(coffee.getName());

    }


}
