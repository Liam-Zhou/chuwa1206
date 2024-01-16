public class Car {
    private String color; // Private field

    // Public getter and setter methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

public class TestEncapsulation {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColor("Red");
        System.out.println("Car color is: " + car.getColor());
    }
}

