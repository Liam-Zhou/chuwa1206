package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

public class OddEvenPrinter1 {
    private static int number = 1;
    private static final int N = 10;

    public void printOddNumbers() {
        synchronized (this) {
            while (number <= N) {
                if (number % 2 != 0) {
                    System.out.println(Thread.currentThread().getName()+": " + number);
                    number++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printEvenNumbers() {
        synchronized (this) {
            while (number <= N) {
                if (number % 2 == 0) {
                    System.out.println(Thread.currentThread().getName()+": "  + number);
                    number++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter1 printer1=new OddEvenPrinter1();
        Thread oddThread = new Thread(printer1::printOddNumbers);
        Thread evenThread = new Thread(printer1::printEvenNumbers);

        oddThread.start();
        evenThread.start();
    }
}
