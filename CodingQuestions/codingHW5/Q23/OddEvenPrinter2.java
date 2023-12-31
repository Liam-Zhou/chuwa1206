package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class OddEvenPrinter2 {
    private final Lock lock = new ReentrantLock();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    private int number = 1;
    private final int N = 10;
    private boolean isOddTurn = true;

    public void printOddNumbers() {
        lock.lock();
        try {
            while (number <= N) {
                if (isOddTurn) {
                    System.out.println(Thread.currentThread().getName()+": " + number);
                    number++;
                    isOddTurn = false;
                    evenCondition.signal();
                } else {
                    try {
                        oddCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printEvenNumbers() {
        lock.lock();
        try {
            while (number <= N) {
                if (!isOddTurn) {
                    System.out.println(Thread.currentThread().getName()+": " + number);
                    number++;
                    isOddTurn = true;
                    oddCondition.signal();
                } else {
                    try {
                        evenCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter2 printer2 = new OddEvenPrinter2();
        Thread oddThread = new Thread(printer2::printOddNumbers);
        Thread evenThread = new Thread(printer2::printEvenNumbers);

        oddThread.start();
        evenThread.start();
    }

}
