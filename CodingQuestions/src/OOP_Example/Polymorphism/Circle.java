package OOP_Example.Polymorphism;

public class Circle extends Shape{

    public Circle(double a) {
        super(a);
    }

    public Circle() {
        super();
    }

    @Override
    double getArea() {
        return Math.PI * a * a;
    }

}
