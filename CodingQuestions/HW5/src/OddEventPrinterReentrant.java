import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEventPrinterReentrant {
    private final static Lock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable printRunnable = new PrintRunnable();
        Thread t1 = new Thread(printRunnable);
        Thread t2 = new Thread(printRunnable);
        t1.start();
        t2.start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signal();
                    try {
                        if (value <= 10) {
                            condition.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
