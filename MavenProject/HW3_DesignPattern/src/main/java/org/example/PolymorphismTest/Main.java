package org.example.PolymorphismTest;

public class Main {
    public static void main(String[] args) {
        A object = new B();
        object.print();
        System.out.println(object.name);

    }

    private static class A{
        String name = "A";
        public void print(){
            System.out.println("This is A");
        }
    }

    public static class B extends A{
        String name = "B";

        @Override
        public void print(){
            System.out.println("This is B");
        }
    }
}