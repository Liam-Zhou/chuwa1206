public class OddEventPrinterWaitNotify {
    private static final Object lock = new Object();
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
            synchronized (lock) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    lock.notify();
                    try {
                        if (value <= 10) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
