package com.chuwa.learn.observer;

public class Client {
    public static void main(String[] args){
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new User("aaa"));
        subject.notify("update");
    }
}
