package com.chuwa.exercise.t08_multithreading;

public class HW24_Practice23 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        t1.start();
        t2.start();

    }

}


class Thread1 extends Thread{
    private static final Object lock = new Object();
    private static int counter = 1;
    @Override
    public void run(){
            synchronized (lock){
                while (counter <= 10){
                    System.out.println(counter);
                    counter++;

                    lock.notify();
                    try {
                        if (counter < 11){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        }
    }

