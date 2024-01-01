package Coding.UnitiCurrrentLock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockLearn {


    public static void main(String[] args)throws InterruptedException {

        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();
        List<Thread> tWrites = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread tRead = new Thread(() -> {
                int[] nums = counter.get();
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            });
            tRead.start();
            threads.add(tRead);
        }
        for (int j = 0; j < 2; j++) {
            Thread tWrite = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    counter.inc(i);
                }
            });
            tWrite.start();
            tWrites.add(tWrite);
        }



        Thread.sleep(15000);
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }



    }



    class Counter{

        int[] count = new int[10];
        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private final Lock writeLock = lock.writeLock();
        private final Lock readLock = lock.readLock();

        public void inc(int index){

            writeLock.lock();

            try {
                count[index]++;

            }

            finally {

                writeLock.unlock();
            }
        }

        public int[] get(){

            readLock.lock();

            try{

                return Arrays.copyOfRange(count,0,count.length);

            }
            finally {
                readLock.unlock();
            }
        }
    }


