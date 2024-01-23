package com.chuwa.learn.pattern.factory;

public class Coffee {

    public String getName() {
        return "Coffee";
    }

    public void addMilk() {
        System.out.println("add milk");
    }

    public void addSugar() {
        System.out.println("add sugar");
    }

}