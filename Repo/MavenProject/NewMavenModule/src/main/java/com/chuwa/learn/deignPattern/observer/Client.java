package Repo.MavenProject.NewMavenModule.src.main.java.com.chuwa.learn.deignPattern.observer;

public class Client {
    public static void main(String[] args) {
        // 1,创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        // 2,订阅公众号
        subject.attach(new WeixinUser("User1"));
        subject.attach(new WeixinUser("User2"));
        subject.attach(new WeixinUser("User3"));

        // 3,公众号更新,发出消息给订阅者(观察者对象)
        subject.notify("ECT!");
    }
}
