package coding_hw5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterWithReentrantLock {
    private static final Lock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static volatile int count = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(OddEvenPrinterWithReentrantLock::printOdd);
        Thread evenThread = new Thread(OddEvenPrinterWithReentrantLock::printEven);

        oddThread.start();
        evenThread.start();
    }

    private static void printOdd() {
        lock.lock();
        try {
            while (count <= 10) {
                if (count % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    evenCondition.signal();
                } else {
                    oddCondition.await();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    private static void printEven() {
        lock.lock();
        try {
            while (count <= 10) {
                if (count % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    oddCondition.signal();
                } else {
                    evenCondition.await();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
