package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    /*

        Atomic Types: AtomicInteger, AtomicLong, AtomicBoolean, AtomicReference

     */
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Increment and get
        int incrementedValue = atomicInt.incrementAndGet();
        System.out.println("Incremented Value: " + incrementedValue);

        // Add and get
        int addedValue = atomicInt.addAndGet(5);
        System.out.println("Added Value: " + addedValue);

        // Get and decrement
        int currentValue = atomicInt.getAndDecrement();
        System.out.println("Current Value (after decrement): " + currentValue);

        // Compare and set
        boolean updated = atomicInt.compareAndSet(5, 10);
        System.out.println("Value updated? " + updated);
        System.out.println("Current Value: " + atomicInt.get());
    }
}
