package Singleton;

public class SingletonEagerImplement {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getSingleton();
        Singleton1 singleton1Test = Singleton1.getSingleton();
        System.out.println(singleton1 == singleton1Test);
    }
}
// eager way
// 1. define it in variable
// 2. define it in static block
class Singleton1 {
    //
    private static Singleton1 singleton = new Singleton1();
    // static block
//    private static Singleton1 singleton;
//    static {
//        singleton = new Singleton1();
//    }

    private Singleton1() {

    }
    public static Singleton1 getSingleton() {
        return singleton;
    }
}
