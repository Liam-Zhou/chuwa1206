package com.chuwa.exercise;

import java.util.Arrays;
import java.util.List;

public class GetAvgByStream {

    public static double getAvg(List<Integer> arr) {
        double res = arr.stream().mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
        System.out.println(getAvg(arr));
    }


}
