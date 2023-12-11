package vehicle;

public class Car extends Vehicle{

    public Car(String license) {
        super(VehicleSize.COMPACT, license);
    }

    public String toString() {
        return "Car";
    }
}
