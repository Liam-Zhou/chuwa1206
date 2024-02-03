package com.chuwa.learn;

public class Main {
    public static void main(String[] args) {
        System.out.println("Encapsulation demo: ");
        Person sam = new Person("Sam", 10);
        System.out.println(sam.getName() + " is " + sam.getAge() + " years old.");
        System.out.println("Polymorphism demo: ");
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.sound();
        myCat.sound();
        System.out.println("Inheritance demo: ");
        Car car = new Car(4, "Toyota");
        car.move();
        car.honk();
    }
}
