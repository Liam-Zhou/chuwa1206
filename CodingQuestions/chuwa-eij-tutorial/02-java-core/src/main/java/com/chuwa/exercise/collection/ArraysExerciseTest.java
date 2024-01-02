package com.chuwa.exercise.collection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        // Retrieving an element
        int thirdElement = numbers[2]; // Indexing starts from 0
        System.out.println("Third element: " + thirdElement);

        // Updating an element
        numbers[4] = 20;
        System.out.println("Updated fifth element: " + numbers[4]);
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
        int[] numbers = { 5, 3, 8, 1, 2, 9, 4, 6, 7, 10 };


        // sort
        Arrays.sort(numbers);
        System.out.println(Arrays.toString((numbers)));
        // Binary Search
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println(index);


        numbers = new int[]{ 5, 3, 8, 1, 2, 9, 4, 6, 7, 10 };
        // Sort part of the array
        Arrays.sort(numbers, 0, 5); // Sorts elements in the range [0, 5)
        System.out.println("Partially sorted array: " + Arrays.toString(numbers));

        // Parallel Sort
        Arrays.parallelSort(numbers); // Useful for large arrays
        System.out.println("Parallel sorted array: " + Arrays.toString(numbers));
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
        // Copy of array
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        // Copy of range of array
        int[] rangeCopiedArray = Arrays.copyOfRange(numbers, 0, 5); // Copies elements from index 0 to 4
        System.out.println("Range copied array: " + Arrays.toString(rangeCopiedArray));
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
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Converting array to list
        List<Integer> list = Arrays.asList(numbers);
        System.out.println("List: " + list);

        // Check if two arrays are equal
        Integer[] numbersCopy = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        boolean areEqual = Arrays.equals(numbers, numbersCopy);
        System.out.println("Arrays are equal: " + areEqual);

        // Fill array with a specific value
        Arrays.fill(numbers, 20);
        System.out.println("Array filled with 20: " + Arrays.toString(numbers));
    }
}
