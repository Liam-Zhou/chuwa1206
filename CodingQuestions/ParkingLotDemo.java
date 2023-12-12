import java.util.*;

// design a basic parking lot system
class ParkingLot{
    private int capacity;
    public int remain;
    private Map<String, Vehicle> parkedVehicles;
    private LinkedList<Vehicle> waitingVehicles;

    public ParkingLot(int capacity){
        this.capacity = capacity;
        this.remain = capacity;
        this.parkedVehicles = new HashMap<>();
        this.waitingVehicles = new LinkedList<>();
    }

    public int getRemainSlot(){
        return this.remain;
    }

    public boolean parkVehicle(Vehicle newVehicle){
        if(parkedVehicles.containsKey(newVehicle.getLicense())){
            System.out.println("Vehicle already inside!");
            return false;
        }
        if(remain > 0 && waitingVehicles.isEmpty()){
            parkedVehicles.put(newVehicle.getLicense(), newVehicle);
            System.out.println("Parked Successful: " + newVehicle.getLicense());
            remain--;
            return true;
        }else{
            System.out.println("Parking lot is full, now " + newVehicle.getLicense()+" is waiting");
            waitingVehicles.add(newVehicle);
            return false;
        }
    }

    public boolean leaveParkingLot(String licensePlate){
        if(!parkedVehicles.containsKey(licensePlate)){
            System.out.println("Vehicle "+ licensePlate+ " not exist!");
            return false;
        }

        parkedVehicles.remove(licensePlate);
        if(waitingVehicles.isEmpty()){
            remain++;
        }else {
            Vehicle waitedVehicle = waitingVehicles.poll();
            parkedVehicles.put(waitedVehicle.getLicense(),waitedVehicle);
            System.out.println("Waited Vehicle: " + waitedVehicle.getLicense() + " Parked Successfully");
        }
        System.out.println("Vehicle: "+licensePlate+ " exit");
        return true;
    }
}

class Vehicle{
    private String licensePlate;

    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }
    public String getLicense(){
        return licensePlate;
    }
}

public class ParkingLotDemo{
    public static void main(String[] args) {
        ParkingLot pkl = new ParkingLot(3);

        pkl.parkVehicle(new Vehicle("AAAAA"));
        pkl.parkVehicle(new Vehicle("BBBBB"));
        pkl.parkVehicle(new Vehicle("CCCCC"));
        pkl.parkVehicle(new Vehicle("DDDDD"));
        pkl.leaveParkingLot("EEEEE");
        pkl.leaveParkingLot("AAAAA");

        pkl.getRemainSlot();

    }
}
