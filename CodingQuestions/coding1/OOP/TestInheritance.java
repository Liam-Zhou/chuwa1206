class Vehicle {  // superclass
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle {  // subclass
    @Override
    void run() {
        System.out.println("Bike is running safely");
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        Bike myBike = new Bike();
        myBike.run();
    }
}

