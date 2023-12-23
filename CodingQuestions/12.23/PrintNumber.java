import java.util.concurrent.locks.ReentrantLock;

/**
 * Question 24
 */
public class PrintNumber implements Runnable {
    private int num = 1;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 10; ++i) {
                System.out.println(Thread.currentThread().getName() + ": " + num++);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new PrintNumber();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t0.start();
        t2.start();
        t1.start();
    }
}
