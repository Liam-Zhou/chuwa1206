package com.chuwa.create;

public class RunnableThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Runnable" + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
