package com.chuwa.bankstatement.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

//    @Scheduled(cron = "*/10 * * * * *")
//    public void scheduledTaskWithCronExpression() {
//        System.out.println("CRON task :: Execution Time - " + dateTimeFormatter.format(LocalDateTime.now()));
//    }

//    @Scheduled(fixedRate = 5000)
//    public void scheduledTaskWithFixedRate() {
//        System.out.println("Fixed Rate task :: Execution Time - " + dateTimeFormatter.format(LocalDateTime.now()));
//    }
//
//    @Scheduled(initialDelay = 2000, fixedRate = 7000)
//    public void scheduledTaskWithDelayAndFixedRate() {
//        System.out.println("Fixed Rate with Delay Task :: Execution Time - " + dateTimeFormatter.format(LocalDateTime.now()));
//    }
}
