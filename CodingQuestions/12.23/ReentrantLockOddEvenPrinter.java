import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Question 23 part b
 */
public class ReentrantLockOddEvenPrinter implements Runnable {
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private int num = 1;

    // version 1
//    @Override
//    public void run() {
//        while (num < 11) {
//            lock.lock();
//            try {
//                if (num >= 11) {
//                    break;
//                }
//                System.out.println(Thread.currentThread().getName() + ": " + num++);
//            } finally {
//                lock.unlock();
//            }
//        }
//    }

    // version 2
    @Override
    public void run() {
        while (num < 11) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": " + num++);
                condition.signalAll();
                if (num < 11) {
                    condition.await();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Runnable runnable = new ReentrantLockOddEvenPrinter();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        t0.start();
        t1.start();
    }
}
