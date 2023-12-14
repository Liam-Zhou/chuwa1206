package hw3.builder;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double engineSize;

    public Car(CarBuilder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.engineSize = builder.engineSize;
    }

    // Getters and no setters to provide immutability
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public double getEngineSize() { return engineSize; }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", engineSize=" + engineSize +
                '}';
    }
}

