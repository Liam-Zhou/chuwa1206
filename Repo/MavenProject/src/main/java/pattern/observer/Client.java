package pattern.observer;

public class Client {
    public static void main(String[] args) {
        Subject subject = new SubscriptionSubject();

        subject.attach(new WechatUser("Frank"));
        subject.attach(new WechatUser("Jason"));
        subject.attach(new WechatUser("Chris"));

        subject.notify("Hello World");
    }
}
