import parkinglot.*;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String RED = "\033[0;31m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String RESET = "\033[0m";   // RESET

    private
    enum State {
        TOP,
        INPUT_LICENSE,
        SELECT_VEHICLE,
        SELECT_LEVEL,
        VACATE,
    }

    public static ParkingLot generateParkingLot(int numLevels, int spacesPerLevel) {
        List<ParkingLotLevel> levels = new ArrayList<>();
        // generate ParkingLotLevels
        for (int i = 0; i < numLevels; i++) {
            // generate ParkingSpaces
            List<ParkingSpace> spaces = new ArrayList<>();
            for (int j = 0; j < spacesPerLevel; j++) {
                if (Math.random() > 0.5) {
                    spaces.add(new CompactParkingSpace());
                } else {
                    spaces.add(new LargeParkingSpace());
                }
            }
            levels.add(new ParkingLotLevel(spaces));
        }

        return new ParkingLot(levels);
    }

    public static void printTopMenu() {
        String menu =
        """
        What do you want to do?
            1. Park
            2. Vacate
        """;
        System.out.println(menu);
    }

    public static void printLicensePlateMenu() {
        System.out.println("Input your license plate:");
    }

    public static void printSelectVehicleMenu() {
        String menu =
        """
        What Vehicle do you have?
            1. Car - You can park in Compact or Large spaces
            2. Truck - You can only park in Large spaces
            3. Back to Top
        """;
        System.out.println(menu);
    }

    public static void printSelectLevelMenu(ParkingLot parkingLot) {
        System.out.println(parkingLot);
        System.out.printf("Select a level to go to (between 1 and %d): ", parkingLot.getNumLevels());
    }

    public static void print(String text, String color) {
        System.out.println(color + text + RESET);
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = generateParkingLot(3, 5);
        State state = State.TOP;
        Vehicle vehicle = null;
        String license = "";

        // Should clean up this mess, but don't have time to do it right now :(
        Scanner scanner = new Scanner(System.in);
        printTopMenu();
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("quit") || input.equals("q")) {
                System.exit(0);
            }
            switch (state) {
                case TOP:
                    state = switch (input) {
                        case "1" -> {
                            printLicensePlateMenu();
                            yield State.INPUT_LICENSE;
                        }
                        case "2" -> {
                            printLicensePlateMenu();
                            yield State.VACATE;
                        }
                        default -> {
                            print("Unrecognized", RED);
                            printTopMenu();
                            yield state;
                        }
                    };
                    break;
                case INPUT_LICENSE:
                    license = input;
                    printSelectVehicleMenu();
                    state = State.SELECT_VEHICLE;
                    break;
                case SELECT_VEHICLE:
                    vehicle = switch (input) {
                        case "1" -> new Car(license);
                        case "2" -> new Truck(license);
                        case "3" -> null;
                        default -> {
                            print("Unrecognized", RED);
                            yield null;
                        }
                    };
                    if (vehicle == null) {
                        printTopMenu();
                        state = State.TOP;
                    } else {
                        printSelectLevelMenu(parkingLot);
                        state = State.SELECT_LEVEL;
                    }
                    break;
                case SELECT_LEVEL:
                    int level;
                    try { level = Integer.parseInt(input); }
                    catch (Exception e) {
                        print("Please input a number.", RED);
                        printSelectLevelMenu(parkingLot);
                        break;
                    }
                    if (level < 1 || level > parkingLot.getNumLevels()) {
                        print("Input range invalid.", RED);
                        printSelectLevelMenu(parkingLot);
                        break;
                    }
                    ParkingSpace space = null;
                    try {
                        space = parkingLot.park(level, vehicle);
                    } catch (IllegalArgumentException e) {
                        print(e.getMessage(), YELLOW);
                    }
                    if (space == null) {
                        printSelectLevelMenu(parkingLot);
                        break;
                    } else {
                        print("Parked in " + space.getSize(), GREEN);
                    }
                    state = State.TOP;
                    printTopMenu();
                    break;
                case VACATE:
                    if (parkingLot.vacate(input)) {
                        print("You left your parking spot. Have a good day!", GREEN);
                    } else {
                        print("Unable to find vehicle with that license plate", YELLOW);
                    }
                    state = State.TOP;
                    printTopMenu();
                    break;
                default:
                    printTopMenu();
            }
        }
    }
}