package oop.AbstractionAndInterface.SameMethodinInterface;

public interface interfaceA {

    default void printSomething() {
        System.out.println("I am inside A interface");
    }
    double calculatePrice(Integer sku); //Sku = Item Number, QR-Code, Bar-Code
}
