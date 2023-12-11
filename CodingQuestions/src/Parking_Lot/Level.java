package Parking_Lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level {
    private int floor;
    private boolean isFull;
    private List<ParkingSpot> spots;
    private Map<Type, Integer> spotsAvailable;

    public Level(int floor, int capacity) {
        this.floor = floor;
        this.spots = new ArrayList<ParkingSpot>();
    }

    public int getFloor() {
        return floor;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public boolean assignSpot(Vehicle v) {
        if (v.getVehicleType() == Type.HANDICAPPED) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getType() == Type.HANDICAPPED) {
                    spot.setAvailable(false);
                    spot.setVehicle(v);
                    v.setParkingSpot(spot);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.COMPACT) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getType() == Type.COMPACT) {
                    spot.setAvailable(false);
                    spot.setVehicle(v);
                    v.setParkingSpot(spot);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.LARGE) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getType() == Type.LARGE) {
                    spot.setAvailable(false);
                    spot.setVehicle(v);
                    v.setParkingSpot(spot);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.MOTORBIKE) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getType() == Type.MOTORBIKE) {
                    spot.setAvailable(false);
                    spot.setVehicle(v);
                    v.setParkingSpot(spot);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.ELECTRIC) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getType() == Type.ELECTRIC) {
                    spot.setAvailable(false);
                    spot.setVehicle(v);
                    v.setParkingSpot(spot);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle v) {
        if (v.getVehicleType() == Type.HANDICAPPED) {
            for (ParkingSpot spot : spots) {
                if (spot.getVehicle() == v) {
                    spot.setAvailable(true);
                    spot.setVehicle(null);
                    v.setParkingSpot(null);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.COMPACT) {
            for (ParkingSpot spot : spots) {
                if (spot.getVehicle() == v) {
                    spot.setAvailable(true);
                    spot.setVehicle(null);
                    v.setParkingSpot(null);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.LARGE) {
            for (ParkingSpot spot : spots) {
                if (spot.getVehicle() == v) {
                    spot.setAvailable(true);
                    spot.setVehicle(null);
                    v.setParkingSpot(null);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.MOTORBIKE) {
            for (ParkingSpot spot : spots) {
                if (spot.getVehicle() == v) {
                    spot.setAvailable(true);
                    spot.setVehicle(null);
                    v.setParkingSpot(null);
                    return true;
                }
            }
        } else if (v.getVehicleType() == Type.ELECTRIC) {
            for (ParkingSpot spot : spots) {
                if (spot.getVehicle() == v) {
                    spot.setAvailable(true);
                    spot.setVehicle(null);
                    v.setParkingSpot(null);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    public int getAvailableSpotsByType(Type type) {
        int availableSpots = 0;
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getType() == type) {
                availableSpots++;
            }
        }
        return availableSpots;
    }

    public void displayAvailableSpots() {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                System.out.println("Floor: " + floor + ", Spot: " + spot.getNumber() + ", Type: " + spot.getType());
            }
        }
    }

}
