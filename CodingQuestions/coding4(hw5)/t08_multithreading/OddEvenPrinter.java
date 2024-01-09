package com.chuwa.tutorial.t08_multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
    private static final Object obj = new Object();
    private static Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean isOddTurn = true;

    private static int value = 1;
    public static void main(String[] args) {
//        printRunnable pr = new printRunnable();
//        new Thread(pr).start();
//        new Thread(pr).start();

        PrintRunnable2 prOdd = new PrintRunnable2(true);
        PrintRunnable2 prEven = new PrintRunnable2(false);
        new Thread(prOdd).start();
        new Thread(prEven).start();
    }

    static class printRunnable implements Runnable{

        @Override
        public void run() {
            synchronized (obj){
                while (value <= 10){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    obj.notify();
                    if(value < 11){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    static class PrintRunnable2 implements Runnable{
        private final boolean isOdd;

        PrintRunnable2(boolean isOdd) {
            this.isOdd = isOdd;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while(value < 10){
                    while((isOddTurn && !isOdd) || (!isOddTurn && isOdd)){
                        condition.await();
                    }


                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    isOddTurn = !isOddTurn;
                    condition.signal();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

}
