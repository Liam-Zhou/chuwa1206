enum VehicleSize {
    SMALL, MEDIUM, LARGE
}

class Vehicle {
    protected String licensePlate;
    protected VehicleSize size;
    protected String color;
    protected String model;
    protected String brand;
    protected int parkingDuration;

    public Vehicle(String licensePlate, VehicleSize size, String color, String model, String brand) {
        this.licensePlate = licensePlate;
        this.size = size;
        this.color = color;
        this.model = model;
        this.brand = brand;
    }

    public void startParking(int duration) {
        this.parkingDuration = duration;
    }

    public void endParking() {
        this.parkingDuration = 0;
    }

    public VehicleSize getSize() {
        return size;
    }

    // getters and setters for the new attributes

    // Getter and setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter and setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and setter for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
