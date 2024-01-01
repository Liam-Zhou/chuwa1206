package Coding.UnitiCurrrentLock.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    private static final AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.get());

    }





}
