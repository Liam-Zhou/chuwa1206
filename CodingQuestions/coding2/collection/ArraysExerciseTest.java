package coding2.collection;

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
     * <p>
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        numbers[2] = 100;
        numbers[1] = -5;
    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     * <p>
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     * <p>
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.binarySearch(numbers, 10));
        Arrays.sort(numbers);
        int[] numbers2 = {1, 2, 6, 5, 7, 1, 10, 9, 10};
        Arrays.sort(numbers2, 0, 5);
        for (int x : numbers2) System.out.print(x + "\t");
//        System.out.println(numbers2);
        Arrays.parallelSort(numbers);

    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     * <p>
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] numbers = {1,2};
        int[] t = Arrays.copyOf(numbers, numbers.length - 2);
        System.out.println(t.length);

        int[] numbers2 = {1, 2, 6, 5, 7, 1, 10, 9, 10};
        int[] t2 = Arrays.copyOfRange(numbers2, 2, 5);
        for (int x : t2) System.out.print(x + "\t");
    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     * <p>
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     * <p>
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     */

    @Test
    public void learn_common_operations() {
        int[] nums1 = {1,2,3};
        int[] nums2 = {1,2,3};
        System.out.println(Arrays.equals(nums1, nums2));
        Arrays.fill(nums2, 0x3f3f3f3f);

    }
}
