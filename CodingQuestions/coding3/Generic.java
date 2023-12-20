public class GenericClass<T> {
    T obj;
    public GenericClass(T obj) {
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
}
public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(999);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<>(20.0001);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<>("My first Generic Class");
        System.out.println(obj3.getObj());
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
public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                MaximumGenericTest.maximum(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                MaximumGenericTest.maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                MaximumGenericTest.maximum("pear", "apple", "orange"));
    }
}

public class GenericMultiArguments {
    public static <T1, T2, T3> void temp(T1 x, T2 y, T3 z) {
        System.out.println("This is x = " + x);
        System.out.println("This is y = " + y);
        System.out.println("This is z = " + z);

    }
    public static void main(String[] args) {
        temp(1, "2", 3L);
    }
}

public class NonGeneric {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                MaximumTest.maximum(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                MaximumTest.maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                MaximumTest.maximum("pear", "apple", "orange"));
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