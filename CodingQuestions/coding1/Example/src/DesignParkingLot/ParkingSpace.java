package DesignParkingLot;

class ParkingSpace {
    // pos
    int level;
    int num;
    CarType spaceType;
    Car car;
    boolean occupied;

    public ParkingSpace(int level, int num, CarType spaceType) {
        this.level = level;
        this.num = num;
        this.spaceType = spaceType;
        this.car = null;
        this.occupied = false;
    }

    // check if the car match the space type
    public boolean matchSpace(Car car) {
        if (car.getCartype().equals(this.spaceType)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOccupied() {
        return this.occupied;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setSpaceType(CarType spaceType) {
        this.spaceType = spaceType;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getLevel() {
        return level;
    }

    public int getNum() {
        return num;
    }

    public CarType getSpaceType() {
        return spaceType;
    }

    public Car getCar() {
        return car;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
