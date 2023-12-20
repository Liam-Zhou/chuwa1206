package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 * updated kaiyuan
 * 12/13/23
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

        // Retrieving elements
        assertEquals(5, numbers[4]);

        // Inserting elements
        numbers[0] = 20;
        assertEquals(20, numbers[0]);
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
        int[] numbers = { 3, 2, 1, 5, 4 };

        // Sorting the entire array
        Arrays.sort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);

        // Binary search for an element
        int index = Arrays.binarySearch(numbers, 4);
        assertEquals(3, index);

        numbers = new int[]{3, 2, 1, 5, 4};

        // Sorting a specific range of the array
        Arrays.sort(numbers, 0, 3);
        assertArrayEquals(new int[]{1, 2, 3, 5, 4}, numbers);

        // Parallel sort
        Arrays.parallelSort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
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
        int[] numbers = { 1, 2, 3, 4, 5 };

        // Copying the entire array
        int[] copied = Arrays.copyOf(numbers, numbers.length);
        assertArrayEquals(numbers, copied);

        // Copying a range of the array
        int[] rangeCopy = Arrays.copyOfRange(numbers, 0, 3);
        assertArrayEquals(new int[]{1, 2, 3}, rangeCopy);
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
        Integer[] numbers = { 1, 2, 3, 4, 5 };
        Integer[] numbers2 = { 1, 2, 3, 4, 5 };

        // Converting array to a list
        List<Integer> list = Arrays.asList(numbers);
        assertEquals(5, list.size());

        // Checking if two arrays are equal
        assertTrue(Arrays.equals(numbers, numbers2));

        // Filling an array with a specific value
        Arrays.fill(numbers, 20);
        assertTrue(Arrays.stream(numbers).allMatch(n -> n == 20));
    }
}
