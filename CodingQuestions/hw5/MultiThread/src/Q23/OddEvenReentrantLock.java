package Q23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenReentrantLock {
    private static final int MAX = 10;
    private int number = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void printOdd() {
        try {
            lock.lock();
            while (number < MAX) {
                if (number % 2 == 0) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                condition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        try {
            lock.lock();
            while (number <= MAX) {
                if (number % 2 != 0) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                condition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OddEvenReentrantLock printer = new OddEvenReentrantLock();

        Thread t1 = new Thread(printer::printOdd, "Odd Thread");
        Thread t2 = new Thread(printer::printEven, "Even Thread");

        t1.start();
        t2.start();
    }
}
