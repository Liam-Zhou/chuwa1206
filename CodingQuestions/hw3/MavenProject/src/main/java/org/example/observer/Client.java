package org.example.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WeiXinUser("a"));
        subject.attach(new WeiXinUser("b"));
        subject.attach(new WeiXinUser("c"));
        subject.notify("Update");
    }
}
