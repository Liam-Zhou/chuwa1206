package streamExercise;

import java.util.Arrays;

public class getAverage {
    public static void main(String[] args) {
        int[] nums = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

        double res = Arrays.stream(nums)
                .average()
                .orElse(Double.NaN);

        System.out.println("Average is " + res);
    }

}
