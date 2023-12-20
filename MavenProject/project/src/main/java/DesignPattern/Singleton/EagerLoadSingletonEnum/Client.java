package DesignPattern.Singleton.EagerLoadSingletonEnum;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
    }
}
