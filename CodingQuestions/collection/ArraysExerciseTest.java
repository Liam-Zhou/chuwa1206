package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(1, numbers[0]);
        numbers[0] = 2;
        assertEquals(2, numbers[0]);
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
        int[] numbers = { 10, 4, 4, 3, 2, 15 };
        System.out.println(Arrays.binarySearch(numbers, 4));
        Arrays.sort(numbers);

        int[] numbers1 = { 10, 4, 4, 3, 15, 2 };
        Arrays.sort(numbers1);
        System.out.println(Arrays.toString(numbers1));

        int[] numbers2 = { 10, 4, 4, 3, 15, 2 };
        Arrays.sort(numbers2, 3,6);
        System.out.println(Arrays.toString(numbers2));

        int[] numbers3 = { 10, 4, 4, 3, 15, 2 };
        Arrays.parallelSort(numbers3);
        System.out.println(Arrays.toString(numbers3));
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
        int[] numbers = { 10, 4, 4, 3, 2, 15 };
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copy));

        int[] copy1 = Arrays.copyOfRange(numbers, 0, 4);
        System.out.println(Arrays.toString(copy1));
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
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5);

        assertTrue(Arrays.equals(numbers1.toArray(new Integer[0]), numbers2.toArray(new Integer[0])));

        int[] newArray = new int[20];
        Arrays.fill(newArray, 10);
        System.out.println(Arrays.toString(newArray));
    }
}
