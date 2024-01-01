package Coding;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class NumberPrinterMain {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread thread1 = new Thread(() -> printer.printNumbers(1, 10), "Thread1");
        Thread thread2 = new Thread(() -> printer.printNumbers(11, 20), "Thread2");
        Thread thread3 = new Thread(() -> printer.printNumbers(21, 22), "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();
        }
        static class NumberPrinter {
            private final Lock lock = new ReentrantLock();
            private int currentNumber = 1;

            public void printNumbers(int start, int end) {
                lock.lock();
                try {
                    while (currentNumber <= end) {
                        if (currentNumber >= start && currentNumber <= end) {
                            System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                            currentNumber++;
                        }
                        try {
                            // Introduce some randomness in the sequence
                            Thread.sleep((long) (Math.random() * 100));
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
