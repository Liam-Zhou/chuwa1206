package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsPrinting2 {

    public static void main(String[] args) {
        Runnable runnable = new Task();
        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }


    }

    private static class Task implements Runnable {
        static int count = 1;
        static final Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                }
                lock.notifyAll();
            }


        }
    }
}
