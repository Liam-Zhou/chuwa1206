package com.chuwa.tutorial.t01_basic.zhaokuan_chen_generic;

import java.util.InputMismatchException;
import java.util.List;

public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Min of %d, %d, %d, is %d\n", 10, 8, 20,
                MinimumGeneric.minimum(List.of(10, 8, 20)));
        System.out.printf("Min of %d, %d, %d, is %d\n", 1, -10, 0,
                MinimumGeneric.minimum(List.of(1, -10, 0)));
        System.out.printf("Min of %.2f, %.2f, %.2f, is %.2f\n", 30.0, 30.1, -1.2,
                MinimumGeneric.minimum(List.of(30.0, 30.1, -1.2)));
        System.out.printf("Min of %s, %s, %s, is %s\n", "Banana", "Orange", "Apple",
                MinimumGeneric.minimum(List.of("Banana", "Orange", "Apple")));
    }
}

class MinimumGeneric {
    public static <T extends Comparable<T>> T minimum(List<T> objs) throws RuntimeException {
        if (objs.isEmpty()) {
            throw new RuntimeException("No arguments provided");
        }
        T min = objs.get(0);

        for (int i = 1; i < objs.size(); ++i) {
            if (objs.get(i).compareTo(min) < 0) {
                min = objs.get(i);
            }
        }

        return min;
    }
}