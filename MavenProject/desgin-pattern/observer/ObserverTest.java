package com.java.observer;

public class ObserverTest {
    public static void main(String[] args) {
        SubscriptionSubject subject=new SubscriptionSubject();

        subject.attach(new WechatUser("Jackson"));
        subject.attach(new WechatUser("Jack"));
        subject.attach(new WechatUser("Sam"));

        subject.notify("There is an update!");
    }
}
