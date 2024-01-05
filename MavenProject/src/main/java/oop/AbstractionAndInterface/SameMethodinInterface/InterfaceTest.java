package oop.AbstractionAndInterface.SameMethodinInterface;

public class InterfaceTest implements interfaceA, interfaceB{
    @Override
    public void printSomething() {
        // Option 1 重新写一个 -> Provide our own implementation.
        System.out.println("I am inside Main class");

        // Option 2 选一个父亲 -> Use existing implementation from interfaceA or interfaceB or both.
        interfaceA.super.printSomething();
        interfaceB.super.printSomething();
    }

    @Override
    public double calculatePrice(Integer sku) {
        return 0;
    }

    public static void main(String[] args) {
        //new obj of InterfaceTest
        InterfaceTest interfaceTest = new InterfaceTest();
        //call method on interfaceTest obj
        interfaceTest.printSomething();
//        InterfaceTest.printSomething();
    }
}
