package DesignPattern.Singleton.LazyLoadSingleton3;


public class Client {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2 == singleton);
    }

}
