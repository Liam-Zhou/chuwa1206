# OOD - Parking Lot

## Clarify

1. This parking lot has multiple level
2. The payment should be calculated at an hourly rate
3. There are four types of parking spots: handicapped, small, compact, large
4. In the code, should use Enums, protected, final, abstract, public static final

## Core Objects

- Vehicle
- Car
- Bus
- Motocycle
- ParkingLot
- Spot

## Cases

- Get available parking spot count
- Park vehicle
- Clear spot
- Calculate price

## Classes

```
Vehicle
# int size
+ int getSize()

Car extends Vehicle
Motorcycle extends Vehicle
Bus extends Vehicle

Spot
- boolean available
- Level level
+ boolean isAvailable
+ void takeSpot()
+ void leaveSpot()

Level
- List<Spot> spots
- availableCount
+ int getAvailableCount()
+ void updateAvailableCount()

ParkingLot
- List<Level> levels
- float hourlyRate
+ int getAvailableCount()
- List<Spot> findSpotForVehicle(Vehicle v)
+ Ticket parkVehicle(Vehicle v)
+ void clearSpot(Ticket t)
- float calculatePrice(Ticket t)

Ticket
- Vehicle v
- Spot spot
- Time startTime

ParkingLotFullException

InvalidTicketException
```

## Code

```java
enum VehicleSize {
	SMALL,COMPACT,LARGE
}

abstract class Vehicle {
	protected VehicleSize size;
	public VehicleSize getSize() {
		return this.size();
	}
}

class Motorcycle extends Vehicle {
    public Motorcycle() {
        this.size = VehicleSize.SMALL;
    }
}

class Car extends Vehicle {
    public Car() {
        this.size = VehicleSize.COMPACT;
    }
}

class Bus extends Vehicle {
    public Bus() {
        this.size = VehicleSize.LARGE;
    }
}

// Spot
// - boolean available
// - Level level
// + boolean isAvailable
// + void takeSpot()
// + void leaveSpot()
abstarct class Spot {
    private UUID uuid;
		private boolean available;
		private Level level;
    private VehicleSize size;

    public Spot() {
        this.uuid = UUID.randomUUID();
        this.available = false;
    }

    public VehicleSize getSize() {
        return this.size();
    }
	
		public boolean isAvailable() {
			return this.available;
		}

		public void takeSpot() {
			this.available = false;
		}

		public void leaveSpot() {
			this.available = true;
		}
}

class smallSpot extends Spot {
    public smallSpot(UUID id) {
        super(id);
        this.size = VehicleSize.SMALL;
    }
}

class CompactSpot extends Spot {
    public CompactSpot(UUID id) {
        super(id);
        this.size = VehicleSize.COMPACT;
    }
}

class LargeSpot extends Spot {
    public LargeSpot(UUID id) {
        super(id);
        this.size = VehicleSize.LARGE;
    }
}

// Level
// - List<Spot> spots
// - availableCount
// + int getAvailableCount()
// + void updateAvailableCount()
class Level {
    private final List<Spot> spots;
    private int availableCount;

    public int getAvailableCount() {
        return this.availableCount;
    }

    public void updateAvailableCount() {
        int count = 0;
        for (Spot spot : spots) {
            if (spots.isAvailable()) {
                count++;
            }
            this.availableCount = count;
        }
    }
}

// Ticket
// - Vehicle v
// - Spot spot
// - Time startTime
class Ticket {
    private Vehicle vehicle;
    private Spot spot;
    LocalDateTime startTime;

    public Spot getSpot() {
        return this.spot;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }
}

// ParkingLot
// - List<Level> levels
// - float hourlyRate
// + int getAvailableCount()
// - Spot findSpotForVehicle(Vehicle v)
// + Ticket parkVehicle(Vehicle v)
// + void clearSpot(Ticket t)
// - float calculatePrice(Ticket t)
class ParkingLot {
    private final List<Level> levels;
    private float hourlyRate;

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getAvailableCount() {
        int count = 0;
        for (Level level : levels) {
            count += level.getAvailableCount();
        }
        return count;
    }

    private Spot findSpotForVehicle(Vehicle v) {
        for (Level level : levels) {
            for (Spot spot : level) {
                if (spot.isAvailable() && spot.getSize().ordinal() >= v.getSize().ordinal()) {
                    return spot;
                }
            }
        }
    }

    public Ticket parkVehicle(Vehicle v) {
        Spot spot = findSpotForVehicle(v);
        spot.takeSpot();
        return new Ticket(v, spot);
    }

    public void clearSpot(Ticket t) {
        Spot spot = t.getSpot();
        spot.leaveSpot();
    }

    public float calculatePrice(Ticket t) {
        LocalDateTime startTime = t.getStartTime();
        LocalDateTime endTime = LocalDateTime.now();

        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();

        return (float) (this.hourlyRate * hours);
    }
}
```

