package generic;


public class NonGeneric {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 1, 2, 3,
                MaximumTest.maximum(1, 2, 3));
        System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n\n", 3.1, 3.5, 1.2,
                MaximumTest.maximum(3.1, 3.5, 1.2));
        System.out.printf("Max of %s, %s and %s is %s\n", "x", "z", "y",
                MaximumTest.maximum("x", "z", "y"));
    }
}

class MaximumTest {

    public static int maximum(int x, int y, int z) {
        int max = x;
        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }

    public static double maximum(double x, double y, double z) {
        double max = x;
        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }

    public static String maximum(String x, String y, String z) {
        String max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}