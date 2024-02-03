package com.chuwa.learn.observer;

public class WeChatUser implements Observer{
    private String name;

    public WeChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
