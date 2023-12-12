public class ParkingSpace{
    private boolean isOccupied;
    private final int spaceNumber;

    public ParkingSpace(int spaceNumber){
        this.spaceNumber=spaceNumber;
        this.isOccupied=false;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void occupy(){
        this.isOccupied=true;
    }

    public void vacate(){
        this.isOccupied=false;
    }

    public int getSpaceNumber(){
        return spaceNumber;
    }
}


class ParkingLot{
    private ParkingSpace[] spaces;

    public ParkingLot(int numberOfSpaces){
        spaces=new ParkingSpace[numberOfSpaces];
        for(int i=0;i<numberOfSpaces;i++){
            spaces[i]=new ParkingSpace(i);
        }
    }

    public boolean park(){
        for (ParkingSpace space: spaces){
            if (!space.isOccupied()){
                space.occupy();
                System.out.println("Vehiele parked in space "+space.getSpaceNumber());
                return true;
            }
        }

        System.out.println("Parking lot is full!!!");
        return false;
    }

    public void leave(int spaceNumber){
        if(spaceNumber<spaces.length && spaces[spaceNumber].isOccupied()){
            spaces[spaceNumber].vacate();
            System.out.println("Vehicle left from space "+spaceNumber);
        } else {
            System.out.println("There is no vehicle in the parking lot!!");
        }
    }
}


class Vehicle{
    private String plate;

    public Vehicle(String plate){
        this.plate=plate;
    }

    public String checkPlate(){
        return plate;
    }
}

public class Main {
    public static void main(String[] args){
        ParkingLot lot = new ParkingLot(5);
        Vehicle car = new Vehicle("UVA23");

        //Park a vehicle
        lot.park();
    }
}



