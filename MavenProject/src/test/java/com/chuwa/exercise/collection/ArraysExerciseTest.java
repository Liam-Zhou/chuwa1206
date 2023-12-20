package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(2, numbers[1]);
        numbers[1] = 1;
        assertEquals(1, numbers[1]);
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        assertEquals(3, Arrays.binarySearch(numbers, 4));

        int[] numbers2 = {5, 4, 3, 2, 1};
        Arrays.sort(numbers2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers2);

        numbers2 = new int[]{5, 4, 3, 2, 1};
        Arrays.sort(numbers2, 1, 5);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, numbers2);

        numbers2 = new int[]{5, 4, 3, 2, 1};
        Arrays.parallelSort(numbers2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers2);
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] nums = Arrays.copyOf(numbers, 2);
        assertArrayEquals(new int[]{1, 2}, nums);

        int[] nums2 = Arrays.copyOfRange(numbers, 1, 4);
        assertArrayEquals(new int[]{2, 3, 4}, nums2);
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
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, list.toArray(new Integer[0]));

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] numbers2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        assertTrue(Arrays.equals(numbers, numbers2));

        int[] numbers3 = new int[5];
        Arrays.fill(numbers3, 1);
        assertArrayEquals(new int[]{1,1,1,1,1}, numbers3);
    }
}
