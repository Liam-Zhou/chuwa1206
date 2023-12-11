package org.example;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class ParkingTicket {
    private Instant initTimestamp = null;
    private Instant leaveTimestamp = null;

    public ParkingTicket(){
        initTimestamp = Instant.now();
    }

    public Instant onLeave(){
        leaveTimestamp = Instant.now();
        return leaveTimestamp;
    }

    public long getTimeDiff(){
        Duration duration = Duration.between(initTimestamp, leaveTimestamp);
        long minutesDifferenceAlt = duration.toMinutes();
        return minutesDifferenceAlt;
    }

}
