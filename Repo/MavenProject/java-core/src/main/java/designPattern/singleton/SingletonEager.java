package designPattern.singleton;

public class SingletonEager {
    private SingletonEager(){};
    private static SingletonEager instance = new SingletonEager();
    public static SingletonEager getInstance() {
        return instance;
    }

}
