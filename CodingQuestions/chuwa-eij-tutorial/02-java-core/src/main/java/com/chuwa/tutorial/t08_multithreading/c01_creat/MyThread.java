package com.chuwa.tutorial.t08_multithreading.c01_creat;

/**
 * @author b1go
 * @date 3/21/22 9:02 AM
 */
public class MyThread extends  Thread{
    @Override
    public void run(){

        try {
            System.out.println("MyThread runs");
            sleep(10000);
            System.out.println("MyThread finishes");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
