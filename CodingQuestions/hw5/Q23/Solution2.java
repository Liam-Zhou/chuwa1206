package com.chuwa.exercise.OddEventPrinter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution2 {
    private static int value = 1;
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        Thread t1 = new Thread(printNumber);
        Thread t2 = new Thread(printNumber);
        t1.start();
        t2.start();
    }

    public static class PrintNumber implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signal();

                    try {
                        if (value <= 10) {
                            condition.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}