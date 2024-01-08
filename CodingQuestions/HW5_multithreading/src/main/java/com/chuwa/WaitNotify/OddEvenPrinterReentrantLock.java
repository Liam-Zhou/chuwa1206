package com.chuwa.WaitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterReentrantLock{
    static int value = 1;
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread odd = new Thread(new OddEvenPrinterRe());
        Thread even = new Thread(new OddEvenPrinterRe());
        odd.start();
        even.start();
        try{
            odd.join();
            even.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static class OddEvenPrinterRe implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try{
                while(value < 11){
                    System.out.println(value);
                    value += 1;
                    condition.signal();
                    if(value < 11) condition.await();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }
}



