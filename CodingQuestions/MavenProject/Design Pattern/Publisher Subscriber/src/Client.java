public class Client {
    public static void main(String[] args) {
        //创建公众号对象
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        //订阅公众号
        subscriptionSubject.attach(new WechatUser("莫力布林"));
        subscriptionSubject.attach(new WechatUser("波克布林"));
        subscriptionSubject.attach(new WechatUser("人马老师"));

        //公众号类
        subscriptionSubject.notify("林克醒了");
    }
}
