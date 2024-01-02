package multithreading.ConcurrentLocks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLearn {
    public int incrementAndGet(AtomicInteger var) {
        int prev, next;
        do {
            prev = var.get();
            next = prev + 1;
        } while ( ! var.compareAndSet(prev, next));
        return next;
    }

    public static void main(String[] args) {
        AtomicLearn test = new AtomicLearn();
        System.out.println(test.incrementAndGet(new
                AtomicInteger(1)));
    }
}

class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}