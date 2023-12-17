package pattern.singleton.demo2;

import pattern.singleton.demo1.Singleton;

public class Client {
    public static void main(String[] args) {
        pattern.singleton.demo1.Singleton instance = pattern.singleton.demo1.Singleton.getInstance();
        pattern.singleton.demo1.Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}
