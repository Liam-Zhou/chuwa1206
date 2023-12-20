package Publisher_Subscriber;

// https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9
public class Client {
    public static void main(String[] args) {
        Subject weChat = new SubscriptionSubject();
        weChat.attach(new WeChatUser("A"));
        weChat.attach(new WeChatUser("B"));
        weChat.attach(new WeChatUser("C"));
        weChat.notify("hey!!");
    }
}
