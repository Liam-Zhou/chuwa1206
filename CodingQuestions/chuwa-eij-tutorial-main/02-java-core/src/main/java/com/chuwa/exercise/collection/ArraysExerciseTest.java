package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;


public class ArraysExerciseTest {
    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Test retrieving
        assertEquals(5, numbers[4]);

        // Test inserting
        numbers[0] = 20;
        assertEquals(20, numbers[0]);
    }

    @Test
    public void learn_search_and_sort() {
        int[] numbers = {4, 2, 3, 1, 5};

        // Test binary search on unsorted array (result undefined)
        int searchResult = Arrays.binarySearch(numbers, 4);
        assertTrue(searchResult < 0);

        // Sort the array
        Arrays.sort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);

        // Test binary search on sorted array
        assertEquals(3, Arrays.binarySearch(numbers, 4));

        // Test parallel sort
        Arrays.parallelSort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
    }

    @Test
    public void learn_copy_of_array() {
        int[] numbers = {1, 2, 3, 4, 5};

        // Test copyOf
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        assertArrayEquals(numbers, copy);

        // Test copyOfRange
        int[] rangeCopy = Arrays.copyOfRange(numbers, 0, 3);
        assertArrayEquals(new int[]{1, 2, 3}, rangeCopy);
    }

    @Test
    public void learn_common_operations() {
        Integer[] numbers = {1, 2, 3, 4, 5};

        // Test asList
        List<Integer> list = Arrays.asList(numbers);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);

        // Test equals
        Integer[] numbersCopy = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(numbers, numbersCopy));

        // Test fill
        Arrays.fill(numbers, 20);
        assertTrue(Arrays.stream(numbers).allMatch(n -> n == 20));
    }




}
