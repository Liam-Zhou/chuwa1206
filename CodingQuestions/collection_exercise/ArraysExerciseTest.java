package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        assertEquals(numbers[0],1);
        numbers[0] = 100;
        assertEquals(numbers[0],100);

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
        int[] numbers = { 5, 2, 3, 6, 1, 4, 8, 7, 9, 10 };
        Arrays.sort(numbers);
        // if the array is not in order, it has to be sorted first before binary search
        int i = Arrays.binarySearch(numbers, 4);
        assertEquals(i,3);

        numbers = new int[]{ 5, 2, 3, 6, 1, 4, 8, 7, 9, 10 };
        // only sort between fromIndex(inclusive) to toIndex(exclusive), keeping other elements as it is.
        Arrays.sort(numbers,0,5);
        for (int n : numbers) {
            System.out.println(n);
        }

        /*
         * Parallel sort
         * 1. The array is divided into sub-arrays and that
         *    sub-arrays is again divided into their sub-arrays,
         *    until the minimum level of detail in a set of array.
         * 2. Arrays are sorted individually by multiple thread.
         * 3. The parallel sort uses Fork/Join Concept for sorting.
         * 4. Sorted sub-arrays are then merged.
         * */
        int num = 1;
        Arrays.parallelSort(numbers);
        for (int n : numbers) {
            assertEquals(n, num++);

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
        int[] org = {1,2,3};
        int[] copy = Arrays.copyOf(org, org.length); // if new length > org.length, will append 0
        int i = 1;
        for (int n : copy) {
            assertEquals(n,i++);
        }

        int[] copy2 = Arrays.copyOfRange(org, 0, 5); // if the toindex > length, will append 0
        for (int n : copy2) {
            System.out.println(n);
        }


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
        Integer[] arr = {1,2};
        Integer[] arr2 = {1,2};

        // List<Integer> list = Arrays.asList(int[] {1,2}) doesn't work because asList doesn't do unboxing
        List<Integer> list = Arrays.asList(arr);
        assertTrue(Arrays.equals(arr,arr2));
        assertFalse(arr.equals(arr2));

        Arrays.fill(arr,10);
        for (int n: arr) {
            assertEquals(n,10);
        }

    }
}
