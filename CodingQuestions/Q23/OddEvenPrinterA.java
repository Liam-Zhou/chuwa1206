package Q23;

public class OddEvenPrinterA {
    private static final Object monitor = new Object();

    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable printRunnable = new PrintRunnable();
        Thread thread0 = new Thread(printRunnable);
        Thread thread1 = new Thread(printRunnable);
        thread0.start();
        thread1.start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try {
                        if (value < 11) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
