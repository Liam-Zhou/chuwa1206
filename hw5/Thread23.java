package hw5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread23 {
    class Counter {
        int counter = 1;

        public synchronized void printCounter() {
            while (true) {
                notifyAll();
                if (counter > 10) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + ": " + counter++);
                try {
                    wait();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        //wait notify solution
        Thread23 thread23 = new Thread23();
        Counter counter = thread23.new Counter();

        Thread thread1 = new Thread(() -> counter.printCounter());
        Thread thread2 = new Thread(() -> counter.printCounter());
        thread1.start();
        thread2.start();
    }


    public class AlthernatePrinting {
        private static final Lock lock = new ReentrantLock();
        private static final Condition oddTurn = lock.newCondition();
        private static final Condition evenTurn = lock.newCondition();
        private static volatile boolean isOddTurn = false;

        public static void main(String[] args) {
            Thread oddThread = new Thread(() -> printOddNumbers());
            Thread evenThread = new Thread(() -> printEvenNumbers());

            oddThread.start();
            evenThread.start();
        }

        private static void printOddNumbers() {
            for (int i = 1; i<= 10; i += 2) {
                try {
                    lock.lock();
                    while (!isOddTurn) {
                        oddTurn.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    isOddTurn = false;
                    evenTurn.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }

        private static void printEvenNumbers() {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    lock.lock();
                    while (isOddTurn) {
                        evenTurn.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    isOddTurn = true;
                    oddTurn.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }


    }


}
