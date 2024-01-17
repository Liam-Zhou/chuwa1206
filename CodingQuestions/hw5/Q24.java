package hw5;

public class Q24 {
    private static final Object monitor = new Object();
    private static int value = 1;
    private static final int target = 30;



    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                int prev = value;
                while (value <= target) {
                    System.out.println(Thread.currentThread().getName() + ": " +
                            value++);
                    if (value < prev + 10) {
                        continue;
                    }
                    monitor.notifyAll();
                    try {
                        monitor.wait();
                        prev = value;
                    }  catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}