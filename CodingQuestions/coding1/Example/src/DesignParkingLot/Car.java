package DesignParkingLot;

class Car {
    CarType cartype;
    String licensePlate;

    public Car(CarType cartype, String licensePlate) {
        this.cartype = cartype;
        this.licensePlate = licensePlate;
    }

    public CarType getCartype() {
        return cartype;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setCartype(CarType cartype) {
        this.cartype = cartype;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
