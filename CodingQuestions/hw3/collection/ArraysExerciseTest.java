package com.chuwa.exercise.collection;

import org.junit.Test;

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
        int[] array = new int[5];

        // Inserting elements
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2; // Assigning value
        }

        // Retrieving elements
        for (int j : array) {
            System.out.println("Element: " + j);
        }
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
        int[] array = {3, 1, 4, 1, 5, 9};

        // Sorting array
        Arrays.sort(array);

        // Sorting part of the array (fromIndex inclusive, toIndex exclusive)
        Arrays.sort(array, 1, 4);

        // Parallel sorting
        Arrays.parallelSort(array);

        // Binary search
        int index = Arrays.binarySearch(array, 4); // Searching for 4
        System.out.println("Index of 4: " + index);
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
        int[] original = {1, 2, 3, 4, 5};

        // Copying array
        int[] copy = Arrays.copyOf(original, original.length);

        // Copying range of array
        int[] rangeCopy = Arrays.copyOfRange(original, 1, 4); // Copy from index 1 to 4 (exclusive)

        // Printing copied arrays
        System.out.println("Complete Copy:");
        for (int i : copy) {
            System.out.println(" - " + i);
        }

        System.out.println("Range Copy:");
        for (int i : rangeCopy) {
            System.out.println(" - " + i);
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
        String[] array = {"Apple", "Banana", "Cherry"};

        // Filling array
        Arrays.fill(array, "Filled");

        // Converting to string
        String arrayString = Arrays.toString(array);
        System.out.println("Array as string: " + arrayString);

        // Checking array equality
        String[] anotherArray = {"Filled", "Filled", "Filled"};
        boolean areEqual = Arrays.equals(array, anotherArray);
        System.out.println("Arrays are equal: " + areEqual);
    }
}
