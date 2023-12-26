package CollectionPractice;

import java.util.Arrays;
import java.util.List;

public class ArraysPractice {
    public static void main(String[] args) {
        // 1. learn_Inserting_And_Retrieving
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.binarySearch(numbers, 5));
        Arrays.sort(numbers);
        Arrays.sort(numbers, 0, 2);
        // sort use single thread, while parallelSort use muti-thread
        Arrays.parallelSort(numbers);

        // 2. learn_copy_of_array
        int[] copy = Arrays.copyOf(numbers, 5);
        System.out.println(copy);
        int[] copy2 = Arrays.copyOfRange(numbers, 0, 2);
        System.out.println(copy2);

        // 3. learn_common_operations
        Integer[] a = new Integer[] { 10, 20, 30, 40 };
        // when use the Arrays.asList(), a should be Integer type
        List<Integer> list = Arrays.asList(a);
        System.out.println(list);
        int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.compare(numbers, numbers2));
        Arrays.fill(numbers, 20);
        System.out.println(numbers);

    }
}
