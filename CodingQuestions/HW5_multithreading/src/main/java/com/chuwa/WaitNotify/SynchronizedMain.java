package com.chuwa.WaitNotify;

public class SynchronizedMain {
    static OddEvenPrinter printer = new OddEvenPrinter();

    public static void main(String[] args) {
        Thread even = new Thread(new evenThread());
        Thread odd = new Thread(new oddThread());
        even.start();
        odd.start();
        try {
            even.join();
            odd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class oddThread implements Runnable{

        @Override
        public void run() {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class evenThread implements Runnable{

        @Override
        public void run() {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
