package designPattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeixinUser("user1"));

        subject.notify("ECT!");
    }

}
