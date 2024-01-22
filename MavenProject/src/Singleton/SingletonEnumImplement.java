package Singleton;

public class SingletonEnumImplement {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;

        System.out.println(singleton1 == singleton2);
    }
}
