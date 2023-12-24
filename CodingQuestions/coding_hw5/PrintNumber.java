package coding_hw5;

/**
 * create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.
 *
 */
public class PrintNumber {
    private static final Object lock = new Object();
    private static int currentNumber = 1;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter(1, 10));
        Thread thread2 = new Thread(new NumberPrinter(11, 20));
        Thread thread3 = new Thread(new NumberPrinter(21, 22));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class NumberPrinter implements Runnable {
        private final int start;
        private final int end;

        NumberPrinter(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    while (currentNumber <= end) {
                        if (currentNumber >= start) {
                            System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                            currentNumber++;
                            lock.notifyAll(); // Notify other threads waiting on the lock
                        } else {
                            lock.wait(); // Release the lock and wait for notification
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
