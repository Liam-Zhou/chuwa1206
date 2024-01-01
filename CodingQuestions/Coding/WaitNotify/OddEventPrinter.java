package Coding.WaitNotify;

public class OddEventPrinter {

        private static final Object monitor = new Object();
        private static int value = 1;

        public static void main(String[] args) {
            PrintRunnable runnable = new PrintRunnable();
            new Thread(runnable).start();
            new Thread(runnable).start();
        }

        static class PrintRunnable implements Runnable {
            @Override
            public void run() {
                synchronized (monitor) {
                    while (value <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + value++);
                        monitor.notify();
                        try {
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
// Another solution with ReentrantLock
//class OddEvenPrinter {
//    private final Lock lock = new ReentrantLock();
//    private final Condition oddCondition = lock.newCondition();
//    private final Condition evenCondition = lock.newCondition();
//    private int count = 1;
//    private final int maxCount = 10;
//
//    public void printOdd() {
//        lock.lock();
//        try {
//            while (count <= maxCount) {
//                if (count % 2 != 0) {
//                    System.out.println(Thread.currentThread().getName() + ": " + count);
//                    count++;
//                    evenCondition.signal(); // Signal the waiting thread (even printer)
//                } else {
//                    try {
//                        oddCondition.await(); // Wait for the even printer to finish
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void printEven() {
//        lock.lock();
//        try {
//            while (count <= maxCount) {
//                if (count % 2 == 0) {
//                    System.out.println(Thread.currentThread().getName() + ": " + count);
//                    count++;
//                    oddCondition.signal(); // Signal the waiting thread (odd printer)
//                } else {
//                    try {
//                        evenCondition.await(); // Wait for the odd printer to finish
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//}
//
//public class OddEvenPrinterMain {
//    public static void main(String[] args) {
//        OddEvenPrinter printer = new OddEvenPrinter();
//
//        Thread oddThread = new Thread(printer::printOdd, "OddThread");
//        Thread evenThread = new Thread(printer::printEven, "EvenThread");
//
//        oddThread.start();
//        evenThread.start();
//    }
//}

