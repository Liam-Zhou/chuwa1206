public class SynchronizedPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable p = new PrintRunnable();
        new Thread(p).start();
        new Thread(p).start();
    }

    static class PrintRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (monitor) {
                while(value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    try{
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
