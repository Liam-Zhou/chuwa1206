package hw21.collectionexercise;

import org.junit.Test;

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
        int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        assert list[3]==4;
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
        int[] list = {  6, 7, 8, 9, 10,1, 2, 3, 4, 5, };
        Arrays.sort(list);
        assert Arrays.binarySearch(list,5)==4;
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
        int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] l2=Arrays.copyOf(list,5);
        int[] l3=Arrays.copyOfRange(list,2,7);
        assert l2[4]==5;
        assert l2.length==5;
        assert l3[4]==7;
        assert l3.length==5;
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
        int[] l1={1,2};
        int[] l2={1,2};
        List<Integer> list = Arrays.asList(1,2);
        assert list.get(1)==2;
        assert Arrays.equals(l1,l2);
        Arrays.fill(l1,1);
        assert l1[1]==1;

    }
}
