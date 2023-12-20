package Singleton;

// https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
public class Client {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
