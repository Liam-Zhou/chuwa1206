public class Polymorphism {
    public static void main(String[] args) {
        /*
            polymorphism refers to the same object exhibiting different forms and behaviors.

            Static Polymorphism - Overload (same class) - compile time
            Dynamic Polymorphism - Override (child class) - run time

         */
        // With same interface, we have different implementations and print different words
        Animal2 cat = new Cat();
        Animal2 dog = new Dog();
        cat.print();
        dog.print();
    }
}

interface Animal2 {
    public void print();
}

class Cat implements Animal2{
    @Override
    public void print() {
        System.out.println("This is the implements from cat.");
    }

    //  Overload, same function name with different parameter number / type / sequence
    public void print(int n) {
        System.out.println(1);
    }
}

class Dog implements Animal2{
    @Override
    public void print() {
        System.out.println("This is the implements from dog.");
    }
}
