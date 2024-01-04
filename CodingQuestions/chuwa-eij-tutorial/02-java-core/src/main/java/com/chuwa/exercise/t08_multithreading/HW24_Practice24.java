package com.chuwa.exercise.t08_multithreading;

public class HW24_Practice24 {

    public static void main(String[] args) {

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        CountingThread t3 = new CountingThread();

        t1.start();
        t2.start();
        t3.start();
    }


}

class CountingThread extends Thread{
    private static final Object lock = new Object();
    private static int counter = 1;
    @Override
    public void run(){
        synchronized (lock){
            while(counter <= 30){
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;

                lock.notifyAll();

                try {
                    if (counter <= 30){
                        lock.wait();

                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}