package com.chuwa.transaction.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(fixedRate = 10000)
    public void performTask() {

        System.out.println("Regular task performed at "
                + dateFormat.format(new Date()));

    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void performDelayedTask() {

        System.out.println("Delayed Regular task performed at "
                + dateFormat.format(new Date()));

    }

    @Scheduled(cron = "*/5 * * * * *")
    public void performTaskUsingCron() {

        System.out.println("Regular task performed using Cron at "
                + dateFormat.format(new Date()));

    }

//    @Scheduled(cron = "0/1 * * ? * ?")
//    public void cron() {
//        logger.info("定时执行，时间{}", DateUtil.now());
//    }
}
