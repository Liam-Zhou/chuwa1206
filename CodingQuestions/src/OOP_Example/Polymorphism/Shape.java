package OOP_Example.Polymorphism;

abstract class Shape {
    double a;
    double b;

    public Shape() {
        this.a = 0;
        this.b = 0;
    }

    public Shape(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Shape(double a) {
        this.a = a;
    }

    public void set(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void set(double a) {
        this.a = a;
    }

    abstract double getArea();
}
