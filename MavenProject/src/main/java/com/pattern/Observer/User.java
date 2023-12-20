package com.pattern.Observer;

public class User implements Observer {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + " received message: " + message);
    }

    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }

}
