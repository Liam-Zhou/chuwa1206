package com.chuwa.tutorial.t08_multithreading.c04_deadlock;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[] {
                new Thread(() -> {
                    while(true) {
                        Counter.add(2);
                    }
                }),
                new Thread(() -> {
                    while(true) {
                        Counter.dec(2);
                    }
                }),
        };
        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println("main end");
    }
}

class Counter {
    public static final Object LOCK_A = new Object();
    public static final Object LOCK_B = new Object();
    private static int value = 0;
    private static int another = 0;

    public static void add (int m) {
        synchronized (LOCK_A) {
            value += m; // A
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (LOCK_B) {
                another += m;
            }
        }

        System.out.println("value is: " + value + ", another is: " + another);
    }

    public static void dec(int m) {
        synchronized (LOCK_B) {
            another -= m; //B
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (LOCK_A) {
                value -= m;
            }
        }

        System.out.println("value is: " + value + ", another is: " + another);
    }
}


