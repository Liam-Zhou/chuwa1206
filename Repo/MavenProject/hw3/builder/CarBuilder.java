package hw3.builder;

public class CarBuilder {
    String make;
    String model;
    int year;
    String color;
    double engineSize;

    public CarBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setEngineSize(double engineSize) {
        this.engineSize = engineSize;
        return this;
    }

    public Car build() {
        return new Car(this);
    }
}

