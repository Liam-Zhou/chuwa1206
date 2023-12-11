import java.util.Map;
import java.util.Set;

public abstract class ParkingLot {
    private Set<String> availableSpots;

    // parking spot -> vehicle
    private Map<String, Vehicle> parkedSpot;

    private float hourlyRate;

    ParkingLot() {

    };

    public abstract Set<String> getAvailableSpots();

    public abstract void parkCar(Vehicle vehicle, String spot, float duration);

    public abstract void pay(String spot, double price);
}
