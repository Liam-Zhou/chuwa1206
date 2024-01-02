package com.chuwa.exercise.OddEventPrinter;

public class Solution1 {
    private static final Object lock = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintNumber printNumberRunnable = new PrintNumber();
        Thread t1 = new Thread(printNumberRunnable);
        Thread t2 = new Thread(printNumberRunnable);
        t1.start();
        t2.start();

    }

    public static class PrintNumber implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    lock.notify();
                    try {
                        if (value < 11) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}