package chuwa.hw2.exception;

// vehicle to be unparked cannot be found in the parking lot
public class InvalidVehicleNumberException extends Exception{
    public InvalidVehicleNumberException(String message) {
        super(message);
    }
}
