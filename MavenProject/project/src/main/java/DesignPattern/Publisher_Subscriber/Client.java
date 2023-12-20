package DesignPattern.Publisher_Subscriber;

public class Client {
    public static void main(String[] args) {
        Subject publisher = new SubjectSubscription();
        publisher.attach(new WeixinUser("1"));
        publisher.notify("update");

    }
}
