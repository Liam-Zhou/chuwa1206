import java.time.LocalDateTime;

public abstract class Vehicle {
    private String plateNumber;
    private String color;
    private LocalDateTime parkingStart;
    private float duration;

    Vehicle() {

    }

    private float priceOwe;

    public abstract void setPriceOwe(float priceOwe);

    public abstract void setDuration(float duration);
}
