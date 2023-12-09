package Polymorphism;

public class Client {
    public static void main(String[] args) {
        Fruit apple = new Apple("sweet");
        Fruit durian = new Durian("stink");
        System.out.println(apple.getSmell());
        System.out.println(durian.getSmell());
    }
}
