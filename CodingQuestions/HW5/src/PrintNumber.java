public class PrintNumber {
    private static int value = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(PrintNumber::printRunnable);
        Thread t2 = new Thread(PrintNumber::printRunnable);
        Thread t3 = new Thread(PrintNumber::printRunnable);
        t1.start();
        t2.start();
        t3.start();
    }

    private synchronized static void printRunnable() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + value++);
        }
        PrintNumber.class.notifyAll();
    }
}
