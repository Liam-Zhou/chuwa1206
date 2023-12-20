package com.chuwa.MethodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReference {
    public static void main(String[] args){
        List<Integer> mylist = Arrays.asList(3, 2, 5, 4, 1);
        mylist.sort((n1, n2) -> n2 - n1); //reverse order
        System.out.println(mylist);

        List<Integer> mylist2 = Arrays.asList(6,4,2,7,9);
        mylist2.sort(myComparator::comparator);
        System.out.println(mylist2);

    }

    private static class myComparator{
        public static int comparator(int n1, int n2){
            return n2 - n1;
        }
    }
}
