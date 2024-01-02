package multithreading.ConcurrentLocks;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// synchronized的进阶版
public class ReentrantLockLearn {
    public static void main(String[] args) {
        CounterReentrant counterReentrant = new CounterReentrant();

        Thread t1 = new Thread(() -> {
            int n = 20;
            while (n-- > 0) {
                counterReentrant.add(2);
                System.out.println("t1 add 2: " + counterReentrant.getCount());
            }
        });

        Thread t2 = new Thread() {
            @Override
            public void run() {
                int n = 20;
                while (n-- > 0) {
                    counterReentrant.add(100);
                    System.out.println("t2 add 100: " + counterReentrant.getCount());
                }
            }
        };

        t1.start();
        t2.start();
        System.out.println("Main end");
    }
}



class CounterReentrant {
    private final Lock lock = new ReentrantLock();
//    private int count;

    private final AtomicInteger count = new AtomicInteger();
    public void add(int n) {
        lock.lock();
        try {
//            count += n;
            count.addAndGet(n);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
//        return count;
        return count.get();
    }
}
//    t2 add 100: 408
//        t1 add 2: 410
//        t2 add 100: 510
//        t1 add 2: 512
//        t1 add 2: 614
//        t2 add 100: 612
// 这种交替执行可能导致输出结果的顺序不同，因此你看到的结果可能是类似上述的情况。
// 这并不一定表示代码有问题，而是多线程环境下输出的结果可能是不确定的，取决于线程的交替执行和执行时机。


class CounterSynchronized {
    private int count;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    public int getCount() {
        return count;
    }
}