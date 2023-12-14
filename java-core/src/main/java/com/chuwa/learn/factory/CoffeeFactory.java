package com.chuwa.learn.factory;

public class CoffeeFactory {
    public static Coffee create(String type){
        if(type.equals("latte")) return new Latte();
        else if (type.equals("americano")) return new Americano();
        return null;
    }

    public static void main(String[] args) {
        Coffee order1=CoffeeFactory.create("latte");
        order1.call();
    }
}
