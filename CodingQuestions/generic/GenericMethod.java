package com.chuwa.tutorial.t01_basic.generic;

/**
 * @author b1go
 * @date 7/25/22 12:03 AM
 */
public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 7, 8, 9,
                MaximumGenericTest.maximum(7, 8, 9));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 10.3, 2.7, 5.8,
                MaximumGenericTest.maximum(10.3, 2.7, 5.8));
        System.out.printf("Max of %s, %s and %s is %s\n", "Jackson", "Jack", "Jason",
                MaximumGenericTest.maximum("Jackson", "Jack", "Jason"));
    }
}


class MaximumGenericTest {
    /**
     * determines the largest of three Comparable objects
     */
    public static < T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}
