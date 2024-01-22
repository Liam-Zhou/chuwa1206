package observer;

public class Client {
    public static void main(String[] args) {
        Subject subject = new SubscriptionSubject();

        subject.attach(new WeixinUser("Tom"));
        subject.attach(new WeixinUser("Dog"));
        subject.attach(new WeixinUser("Cat"));

        subject.notify("It is time to meet.");
    }
}
