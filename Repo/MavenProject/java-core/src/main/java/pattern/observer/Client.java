package pattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeiXinUser("123"));
        subject.attach(new WeiXinUser("456"));
        subject.attach(new WeiXinUser("789"));

        subject.notify("zxc");
    }
}
