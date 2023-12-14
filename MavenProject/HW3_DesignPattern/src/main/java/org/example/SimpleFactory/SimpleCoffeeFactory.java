package org.example.SimpleFactory;

// still breaks Open-Closed Principle (OCP)
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee= null;
        if("Americano".equals(type)){
           coffee = new AmericanoCoffee();
        }
        else{
            throw new RuntimeException("no such coffee");
        }
        return coffee;
    }
}
