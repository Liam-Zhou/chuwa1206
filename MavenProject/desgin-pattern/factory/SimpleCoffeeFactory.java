package com.java.factory;

public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type){
        Coffee coffee=null;
        if ("Americano".equals(type)){
            coffee=new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee=new LatteCoffee();
        }else {
            throw new RuntimeException("Not listed");
        }

        return coffee;
    }
}
