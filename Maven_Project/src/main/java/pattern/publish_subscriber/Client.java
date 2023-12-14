package pattern.publish_subscriber;

/**
 * @program: Maven_Project
 * @ClassName Client
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:35
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeixinUser("Monkey King"));
        subject.attach(new WeixinUser("Pig King"));
        subject.attach(new WeixinUser("Cat King"));

        subject.notify("Good");
    }
}