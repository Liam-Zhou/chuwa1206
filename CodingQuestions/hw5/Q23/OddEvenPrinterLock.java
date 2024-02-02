import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterLock {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (number < 10) {
                lock.lock();
                try {
                    if (number % 2 != 0) {
                        System.out.println("Odd Thread: " + number);
                        number++;
                        condition.signal();
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (number <= 10) {
                lock.lock();
                try {
                    if (number % 2 == 0) {
                        System.out.println("Even Thread: " + number);
                        number++;
                        condition.signal();
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}

