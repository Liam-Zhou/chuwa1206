package OOP_Example.Polymorphism;

public class Rectangle extends Shape{

    public Rectangle(double a, double b) {
        super(a, b);
    }
    @Override
    double getArea() {
        return a * b;
    }

}
