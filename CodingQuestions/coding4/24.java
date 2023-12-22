public class SequencePrinter implements Runnable {
    private static final Object LOCK = new Object();
    private static int current = 1;
    private final int start;
    private final int end;

    public SequencePrinter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        synchronized (LOCK) {
            while (current < start) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = start; i <= end; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                current++;
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SequencePrinter(1, 10), "Thread-0");
        Thread t2 = new Thread(new SequencePrinter(11, 20), "Thread-1");
        Thread t3 = new Thread(new SequencePrinter(21, 30), "Thread-2");
        t1.start();
        t2.start();
        t3.start();
    }
}

