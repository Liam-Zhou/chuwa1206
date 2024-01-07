public class PrintNumber1 {
    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
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

public class ThreadSafeOrNotTest {

    @Test
    public void testGlobalCount() {
        new Thread(() -> Counter.setGlobalCount(1)).start();
        new Thread(() -> Counter.setGlobalCount(2)).start();
        new Thread(() -> Counter.setGlobalCount(3)).start();

        System.out.println(Counter.getGlobalCount());
    }

    @Test
    public void testCount() throws InterruptedException {

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> System.out.println("t1: " + counter.incrementCount()));
        Thread t2 = new Thread(() -> System.out.println("t2: " + counter.decrementCount()));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final result: " + counter.getCount());
    }

    @Test
    public void testSyncronizedCount() throws InterruptedException {

        SyncronizedCounter counter = new SyncronizedCounter();
        Thread t1 = new Thread(() -> System.out.println("t1: " + counter.incrementCount()));
        Thread t2 = new Thread(() -> System.out.println("t2: " + counter.decrementCount()));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final result: " + counter.getCount());
    }

    @Test
    public void testSyncronizedCountWithTwoLocks() throws InterruptedException {

        SyncronizedCounterWithTwoLocks counter = new SyncronizedCounterWithTwoLocks();
        Thread t1 = new Thread(() -> System.out.println("t1: " + counter.incrementCount()));
        Thread t2 = new Thread(() -> System.out.println("t2: " + counter.decrementCount()));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final result: " + counter.getCount());
    }

    @Test
    public void testSyncronizedCountMethod() throws InterruptedException {

        SyncronizedCounterMethod counter = new SyncronizedCounterMethod();
        Thread t1 = new Thread(() -> System.out.println("t1: " + counter.incrementCount()));
        Thread t2 = new Thread(() -> System.out.println("t2: " + counter.decrementCount()));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final result: " + counter.getCount());
    }

    @Test
    public void testAtomicCount() throws InterruptedException {

        AtomicCounter counter = new AtomicCounter();

        Thread t1 = new Thread(() -> System.out.println("t1: " + counter.incrementCount()));
        Thread t2 = new Thread(() -> System.out.println("t2: " + counter.decrementCount()));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("final result: " + counter.getCount());
    }
}

class Counter {
    private Integer count = 0;
    private static Integer globalCount = 0;

    public static Integer getGlobalCount() {
        return globalCount;
    }

    public static void setGlobalCount(Integer globalCount) {
        Counter.globalCount = globalCount;
    }

    public int incrementCount() {
        int k = 10000;
        while (k-- > 0) {
            count++;
        }
        return count;
    }

    public int decrementCount() {
        int k = 10000;
        while (k-- > 0) {
            count--;
        }
        return count;
    }

    public Integer getCount() {
        return count;
    }
}

class SyncronizedCounter {
    private Integer count = 0;
    final Object locker = new Object();

    public int incrementCount() {
        int k = 10000;
        while (k-- > 0) {
            // 这两个方法必须用同一个锁
            synchronized (locker) {
                count++;
            }
        }
        return count;
    }

    public int decrementCount() {
        int k = 10000;
        while (k-- > 0) {
            synchronized (locker) {
                count--;
            }
        }
        return count;
    }

    public Integer getCount() {
        return count;
    }
}


class SyncronizedCounterWithTwoLocks {
    private Integer count = 0;

    final Object locker1 = new Object();
    final Object locker2 = new Object();


    public int incrementCount() {
        int k = 10000;
        while (k-- > 0) {
            synchronized (locker1) {
                count++;
            }
        }
        return count;
    }

    public int decrementCount() {
        int k = 10000;
        while (k-- > 0) {
            synchronized (locker2) {
                count--;
            }
        }
        return count;
    }

    public Integer getCount() {
        return count;
    }
}

class SyncronizedCounterMethod {

    private Integer count = 0;

    public synchronized int incrementCount() {
        int k = 10000;
        while (k-- > 0) {
            count++;
        }
        return count;
    }

    public synchronized int decrementCount() {
        int k = 10000;
        while (k-- > 0) {
            count--;
        }
        return count;
    }

    public Integer getCount() {
        return count;
    }
}

class AtomicCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    public AtomicInteger incrementCount() {
        int k = 10000;
        while (k-- > 0) {
            count.incrementAndGet();
        }
        return count;
    }

    public AtomicInteger decrementCount() {
        int k = 10000;
        while (k-- > 0) {
            count.decrementAndGet();
        }
        return count;
    }

    public AtomicInteger getCount() {
        return count;
    }
}