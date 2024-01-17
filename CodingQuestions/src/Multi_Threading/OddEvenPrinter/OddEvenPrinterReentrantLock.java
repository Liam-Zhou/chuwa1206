package Multi_Threading.OddEvenPrinter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterReentrantLock {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static volatile int count = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (count <= 10) {
                    if (count % 2 == 1) {
                        System.out.println(count++);
                        evenCondition.signal();
                    } else {
                        oddCondition.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                while (count <= 10) {
                    if (count % 2 == 0) {
                        System.out.println(count++);
                        oddCondition.signal();
                    } else {
                        evenCondition.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
