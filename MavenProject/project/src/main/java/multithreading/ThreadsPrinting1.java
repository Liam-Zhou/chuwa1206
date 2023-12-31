package multithreading;

public class ThreadsPrinting1 {
    private static final Object lock = new Object();
    private static int count = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}