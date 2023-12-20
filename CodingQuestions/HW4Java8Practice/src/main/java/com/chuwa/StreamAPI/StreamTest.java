package com.chuwa.StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args){
        List<Integer> mylist = Arrays.asList(1,2,5,4,7);
        Stream<Integer> mystream = mylist.parallelStream();

        int[] myArr = {1,2,3,4,5};
        IntStream mystream2 = Arrays.stream(myArr);

        long cnt = mystream.filter(n -> n >3).count();
        System.out.println(cnt);

        System.out.println(mystream2.anyMatch(n -> n > 4));
        mylist.stream().sorted(Comparator.comparingInt(Integer::intValue)).forEach(System.out::print);
        System.out.println(mylist.stream().max(Comparator.comparingInt(Integer::intValue)));
        System.out.println(mylist.stream().mapToInt(Integer::intValue).min());
        System.out.println(mylist.stream().sorted(Comparator.comparingInt(n -> n)).collect(Collectors.toList()));
        System.out.println(Stream.of(1,4,3,6,6,7).distinct().collect(Collectors.toMap(n -> -n, String::valueOf)));

    }

}
