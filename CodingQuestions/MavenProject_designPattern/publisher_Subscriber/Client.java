package MavenProject_designPattern.publisher_Subscriber;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeiXinUser("jason"));
        subject.attach(new WeiXinUser("elon"));
        subject.attach(new WeiXinUser("bill"));

        //更新，发出消息给订阅者（观察者对象）
        subject.notify("chuwa!!！");
    }
}
