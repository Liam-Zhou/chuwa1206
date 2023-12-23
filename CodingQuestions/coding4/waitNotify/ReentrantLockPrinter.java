import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPrinter {

    public static void main(String[] args) {
        Printer a = new Printer();
        new Thread(a).start();
        new Thread(a).start();
    }

    static class Printer implements Runnable{
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private int value = 1;

        @Override
        public void run() {
            lock.lock();
            while(value <= 10) {
                System.out.println(Thread.currentThread().getName() + ": " + value ++);
                condition.signal();
                try{
                    if(value < 11) {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
