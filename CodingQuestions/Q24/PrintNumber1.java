package Q24;

public class PrintNumber1 {
    private static int n = 1;

    public static void main(String[] args) {
        Thread thread0 = new Thread(() -> printNumber());
        Thread thread1 = new Thread(() -> printNumber());
        Thread thread2 = new Thread(() -> printNumber());

        thread0.start();
        thread1.start();
        thread2.start();
    }

    private static synchronized void printNumber() {
        int count = 0;
        while (count < 10) {
            count++;
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PrintNumber1.class.notifyAll();
    }
}
