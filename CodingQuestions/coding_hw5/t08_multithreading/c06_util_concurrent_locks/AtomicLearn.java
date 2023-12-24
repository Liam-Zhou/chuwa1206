package coding_hw5.t08_multithreading.c06_util_concurrent_locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description 自己利用CAS实现
 */
public class AtomicLearn {
    public int incrementAndGet(AtomicInteger var) {
        int prev, next;
        do {
            prev = var.get();
            next = prev + 1;
        } while ( ! var.compareAndSet(prev, next));
        return next;
    }
}

/**
 * @description 直接使用现有的
 */
class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
