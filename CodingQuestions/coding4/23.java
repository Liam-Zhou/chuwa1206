//a. Using synchronized and wait/notify:
public class OddEvenPrinter {
    private final int MAX = 10;
    private int num = 1;

    public void printOdd() {
        synchronized (this) {
            while (num < MAX) {
                while (num % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + num++);
                notifyAll();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (num < MAX) {
                while (num % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + num++);
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();
        Thread t1 = new Thread(printer::printOdd, "Odd");
        Thread t2 = new Thread(printer::printEven, "Even");
        t1.start();
        t2.start();
    }
}

//b. Using ReentrantLock and await/signal:
public class OddEvenPrinter {
    private final int MAX = 10;
    private int num = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void printOdd() {
        try {
            lock.lock();
            while (num < MAX) {
                while (num % 2 == 0) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + num++);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        try {
            lock.lock();
            while (num < MAX) {
                while (num % 2 == 1) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + num++);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();
        Thread t1 = new Thread(printer::printOdd, "Odd");
        Thread t2 = new Thread(printer::printEven, "Even");
        t1.start();
        t2.start();
    }
}