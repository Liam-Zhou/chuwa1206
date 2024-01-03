package Multi_Threading.OddEvenPrinter;

public class OddEvenPrinterSynchronized {
    private static final Object lock = new Object();
    private static volatile int count = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (count <= 10) {
                        if (count % 2 == 1) {
                            System.out.println(count++);
                            lock.notify();  // 唤醒等待的线程
                        } else {
                            lock.wait();  // 等待被唤醒
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (count <= 10) {
                        if (count % 2 == 0) {
                            System.out.println(count++);
                            lock.notify();  // 唤醒等待的线程
                        } else {
                            lock.wait();  // 等待被唤醒
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
