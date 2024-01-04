package oop.AbstractionAndInterface.SameMethodinInterface;

public interface interfaceB {

    default void printSomething() {
        System.out.println("I am inside B interface");
    }
}

