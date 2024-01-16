/**
 * Question 23 part a
 */
public class OddEvenPrinter implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        printNum();
    }

    public synchronized void printNum() {
        while (num <= 10) {
            System.out.println(Thread.currentThread().getName() + ": " + num++);
            this.notifyAll();
            try {
                if (num < 11){
                    this.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new OddEvenPrinter();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        t0.start();
        t1.start();
    }
}
