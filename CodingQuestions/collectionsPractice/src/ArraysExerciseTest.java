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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        assertEquals(numbers[0], 1);
        assertEquals(numbers[9], 10);
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
        int[] numbers = { 1, 2, 3, 4 };
        int index = Arrays.binarySearch(numbers, 4);
        assertEquals(index, 3);
        int[] numbers2 = {2, 3, 4, 1};
        Arrays.sort(numbers2, 1, 4);
        assertArrayEquals(numbers2, new int[]{2, 1, 3, 4});
        Arrays.parallelSort(numbers2);
        assertArrayEquals(numbers2, new int[]{1, 2, 3, 4});
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
        int[] numbers = { 1, 2, 3, 4 };
        assertArrayEquals(Arrays.copyOf(numbers, 2), new int[]{1, 2});
        assertArrayEquals(Arrays.copyOfRange(numbers, 1, 3), new int[]{2, 3});
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
        Integer[] numbers1 = {1, 2, 3, 4};
        Integer[] numbers2 = {1, 2, 3, 4};
        assertTrue(Arrays.equals(numbers1, numbers2));
        List<Integer> list = Arrays.asList(numbers1);
        assertEquals(list.size(), 4);
        Arrays.fill(numbers1, 20);
        assertTrue(Arrays.stream(numbers1).allMatch(n -> n == 20));
    }
}
