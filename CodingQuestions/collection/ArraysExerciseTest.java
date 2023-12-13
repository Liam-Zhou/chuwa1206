package com.chuwa.exercise.collection;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int num = numbers[2];
        System.out.println(num);
    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //binary search
        System.out.println(Arrays.binarySearch(numbers, 4));

        //sort
        sort(numbers);
        System.out.println(numbers);

        //sort(start, end);
        int[] nums = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        sort(nums, 1, 4);
        for (int num : nums) {
            System.out.println(num + " ");
        }

        //parallelsort
        int[] nums1 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Arrays.parallelSort(nums1);
        for (int num : nums1) {
            System.out.println(num + " ");
        }
    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] nums1 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] copyNum = Arrays.copyOf(nums1, nums1.length);
        int[] copyRange = Arrays.copyOfRange(nums1, 0, 5);

    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {
        int[] nums1 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] nums2 = new int[]{2, 4, 5, 6, 7, 8, 20, 10};

        //aslist()
        List<int[]> list = Arrays.asList(nums1);
        System.out.println("list: " + list);

        //equals
        System.out.println(Arrays.equals(nums1, nums2));

        //fill
        Arrays.fill(nums1, 50);
    }
}
