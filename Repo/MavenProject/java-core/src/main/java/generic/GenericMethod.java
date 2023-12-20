package generic;

public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 1, 2, 3,
                MaximumGenericTest.maximum(1, 2, 3));
        System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n\n", 3.1, 3.5, 1.2,
                MaximumGenericTest.maximum(3.1, 3.5, 1.2));
        System.out.printf("Max of %s, %s and %s is %s\n", "x", "z", "y",
                MaximumGenericTest.maximum("x", "z", "y"));
    }
}


class MaximumGenericTest {

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
