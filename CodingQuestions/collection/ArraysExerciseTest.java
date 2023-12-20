package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
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
        int[] numbers= {1,2,3,4,5};
        assertEquals(3, numbers[2]);

        numbers[0] = 10;
        assertEquals(10, numbers[0]);
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
        int[] numbers = {5, 4, 3, 2, 1};

        int index=Arrays.binarySearch(numbers,6);
        assertFalse(index<0);

        Arrays.sort(numbers);
        assertEquals(1,numbers[0]);
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
        int[] numbers = {1, 2, 3, 4, 5};
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        assertArrayEquals(numbers, copiedArray);

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
        Integer [] numbers = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(numbers);
        assertEquals(5, list.size());

        Integer[] anotherArray = {1, 2, 3, 4, 5};
        assertArrayEquals(numbers, anotherArray);

        Arrays.fill(numbers, 20);

    }
}
