package Singleton;

public enum Singleton {
    INSTANCE
}

public class SingletonEnumImplement {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;

        System.out.println(singleton1 == singleton2);
    }
}

// eager
class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getSingleton() {
        return singleton;
    }
}

// lazy
class Singleton2 {
    private static Singleton2 singleton;

    private Singleton2(){}

    public static Singleton2 getSingleton() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
