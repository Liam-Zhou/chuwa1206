package coding_hw5;

public class OddEvenPrinterWithSynchronized {
    private static final Object monitor = new Object();
    private static int val = 1;

    public static void main(String[] args) {
        PrintRunable runable = new PrintRunable();
        new Thread(runable).start();
        new Thread(runable).start();
//        new Thread(() -> {
//            synchronized (monitor) {
//                while (val <= 10) {
//                    System.out.println(Thread.currentThread().getName() + ": " + val++);
//                    monitor.notify();
//                    try {
//                        if (val < 11) {
//                            monitor.wait();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            synchronized (monitor) {
//                while (val <= 10) {
//                    System.out.println(Thread.currentThread().getName() + ": " + val++);
//                    monitor.notify();
//                    try {
//                        if (val < 11) {
//                            monitor.wait();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
    static class PrintRunable implements Runnable {

        @Override
        public void run() {
            synchronized (monitor) {
                while (val <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + val++);
                    monitor.notify();
                    try {
                        if (val < 11) {
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
