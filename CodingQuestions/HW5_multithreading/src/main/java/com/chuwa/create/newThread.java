package com.chuwa.create;

import java.time.LocalTime;

public class newThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
