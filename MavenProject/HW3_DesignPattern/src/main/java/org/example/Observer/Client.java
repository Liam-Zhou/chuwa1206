package org.example.Observer;

public class Client {
    public static class Main {
        public static void main(String[] args) {
            SubscriptionSubject sub= new SubscriptionSubject();

            sub.attach(new WeixinUser("usr1"));
            sub.attach(new WeixinUser("usr2"));
            sub.attach(new WeixinUser("usr3"));

            sub.notify("Hello");

        }
    }
}
