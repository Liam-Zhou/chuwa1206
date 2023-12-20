package com.chuwa.learn.javacore.Factory;

import javax.management.RuntimeErrorException;

public class SimpleCoffeeFactory {
        public Coffee createCoffee(String type) {
                Coffee coffee = null;
                if ("american".equals(type)) {
                        coffee = new AmericanCoffee();
                } else if ("latte".equals(type)) {
                        coffee = new LatteCoffee();
                } else {
                        throw new RuntimeErrorException("no such coffee");
                }
                return coffee;
        }

}
