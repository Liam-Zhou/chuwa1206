package com.chuwa.create;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        Thread[] threadarr = new Thread[5];

        for(int i = 0; i < 5; i++){
            /* By new Thread()
            threadarr[i] = new newThread();
            */

            /* By Runnable
            threadarr[i] = new Thread(new RunnableThread());
            */


            threadarr[i].start();
            Thread.sleep(100);
        }




        Thread.sleep(6000);
        for(int i = 0; i < 5; i++){
            threadarr[i].join();
        }
    }
}
