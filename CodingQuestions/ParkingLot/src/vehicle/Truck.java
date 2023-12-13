package vehicle;

public class Truck extends Vehicle{

    public Truck(String license) {
        super(VehicleSize.LARGE, license);
    }

    public String toString() {
        return "Truck";
    }
}
