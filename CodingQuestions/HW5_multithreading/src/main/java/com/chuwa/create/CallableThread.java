package com.chuwa.create;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableThread implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        for(int i = 0; i < 5; i++){
            System.out.println("Runnable" + " " + i);
            Thread.sleep(1000);
        }
        double res = new Random().nextDouble();
        return res > 0.5;
    }
}
