package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.*;

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
        System.out.println(numbers[3]);
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
        int[] numbers = {4, 2, 7, 1, 5, 3};

        // Binary Search
        int searchResult = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4: " + searchResult);

        sort(numbers,0,4);
        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        Arrays.parallelSort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
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
        int[] numbers = {4, 2, 7, 1, 5, 3};
        System.out.println(Arrays.toString(copyOf(numbers, numbers.length)));
        System.out.println(Arrays.toString(copyOfRange(numbers, 1,4)));
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

    }
}
