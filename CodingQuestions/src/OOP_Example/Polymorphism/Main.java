package OOP_Example.Polymorphism;

public class Main {
    public static void main(String[] args) {
        // the following code will demosntrate the polymorphism, each shape will have different getArea() method, overriden
        Shape triangle = new Triangle(10, 20);
        System.out.println(triangle.getArea());
        Shape rectangle = new Rectangle(10, 20);
        System.out.println(rectangle.getArea());
        //the set can have two different parameters or 1 parameter, another polymorphism, overloading
        Shape circle = new Circle();
        circle.set(10);
        System.out.println(circle.getArea());
    }
}
