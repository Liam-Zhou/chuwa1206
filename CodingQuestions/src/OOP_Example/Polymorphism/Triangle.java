package OOP_Example.Polymorphism;

public class Triangle extends Shape{

    public Triangle(double a, double b) {
        super(a, b);
    }
    @Override
    double getArea() {
        return a * b / 2;
    }
}
