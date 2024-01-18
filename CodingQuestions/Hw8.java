import java.util.Arrays;
import java.util.OptionalDouble;

public class Hw8 {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        System.out.println(getAvg(arr));
    }

    public static double getAvg(int[] arr) {
        double res = Arrays.stream(arr).average().orElse(Double.NaN);
        return res;
    }
}
