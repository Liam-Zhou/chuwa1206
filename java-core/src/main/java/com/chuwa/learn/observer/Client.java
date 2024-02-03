package com.chuwa.learn.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        subscriptionSubject.attach(new WeChatUser("Sam"));
        subscriptionSubject.attach(new WeChatUser("Amy"));
        subscriptionSubject.attach(new WeChatUser("Lucy"));

        subscriptionSubject.notify("hh");
    }
}
