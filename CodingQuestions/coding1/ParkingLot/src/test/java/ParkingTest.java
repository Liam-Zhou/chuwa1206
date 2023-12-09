import com.chuwa.exception.InvalidVehicleNumberException;
import com.chuwa.exception.ParkingFullException;
import com.chuwa.model.Ticket;
import com.chuwa.model.Vehicle;
import com.chuwa.model.VehicleSize;
import com.chuwa.service.ParkingLot;
import com.chuwa.strategy.FourWheelerWeekDayChargeStrategy;
import com.chuwa.strategy.FourWheelerWeekendChargeStrategy;
import com.chuwa.strategy.TwoWheelerWeekDayChargeStrategy;
import com.chuwa.strategy.TwoWheelerWeekendChargeStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {
    @Test
    public void testFourWheelerWeekDayParkingCost() throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.initializeParkingSlots(10, 10);
        Vehicle vehicle = new Vehicle("1234", VehicleSize.FOURWHEELER);
        Ticket ticket = parkingLot.park(vehicle);
        int cost = parkingLot.unPark(ticket, new FourWheelerWeekDayChargeStrategy());
        assertEquals(20, cost);
    }

    @Test
    public void testFourWheelerWeekendParkingCost() throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.initializeParkingSlots(10, 10);
        Vehicle vehicle = new Vehicle("1234", VehicleSize.FOURWHEELER);
        Ticket ticket = parkingLot.park(vehicle);
        int cost = parkingLot.unPark(ticket, new FourWheelerWeekendChargeStrategy());
        assertEquals(30, cost);
    }

    @Test
    public void testTwoWheelerWeekDayParkingCost() throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.initializeParkingSlots(10, 10);
        Vehicle vehicle = new Vehicle("1234", VehicleSize.TWOWHEELER);
        Ticket ticket = parkingLot.park(vehicle);
        int cost = parkingLot.unPark(ticket, new TwoWheelerWeekDayChargeStrategy());
        assertEquals(10, cost);
    }

    @Test
    public void testTwoWheelerWeekendParkingCost() throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.initializeParkingSlots(10, 10);
        Vehicle vehicle = new Vehicle("1234", VehicleSize.TWOWHEELER);
        Ticket ticket = parkingLot.park(vehicle);
        int cost = parkingLot.unPark(ticket, new TwoWheelerWeekendChargeStrategy());
        assertEquals(15, cost);
    }
}
