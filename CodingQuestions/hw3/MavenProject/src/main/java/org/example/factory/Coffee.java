package org.example.factory;

public abstract class Coffee {
    public abstract String getName();

    public void addSugar() {
        System.out.println("Add sugar");
    }
    public void addMike() {
        System.out.println("Add milk");
    }
}
