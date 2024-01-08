package Q23;

public class OddEven {
    private static final Object lock = new Object();
    private static int num = 1;

    public static void main(String[] args) {
        PrintOddEven runnable = new PrintOddEven();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
    static class PrintOddEven implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (num <= 10){
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    lock.notify();
                    if (num < 11) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
