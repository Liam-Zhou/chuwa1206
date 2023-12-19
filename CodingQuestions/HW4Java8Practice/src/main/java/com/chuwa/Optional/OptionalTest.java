package com.chuwa.Optional;

import java.util.*;

public class OptionalTest {
    public static void main(String[] args){
        List<Integer> mylist = Arrays.asList(1,3,4,7,7,2);
        OptionalInt min = mylist.stream().mapToInt(Integer::intValue).min();

        Optional<Integer> max = mylist.stream().max(Comparator.comparingInt(Integer::intValue));
        int a = max.orElse(0);
        int b = max.orElseGet(() -> 0);
        System.out.println(max);
        System.out.println(a);
    }

}
