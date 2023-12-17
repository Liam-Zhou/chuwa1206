package com.chuwa.exercise.collection;

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
        // 初始化数组
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // 访问数组元素
        System.out.println("Element at index 3: " + numbers[3]); // 输出索引为 3 的元素（第四个元素，值为 4）

        // 修改数组元素
        numbers[3] = 100; // 将索引为 3 的元素值修改为 100

        // 再次访问修改后的元素
        System.out.println("Modified element at index 3: " + numbers[3]); // 输出修改后索引为 3 的元素值（100）
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
        // 初始化数组
        int[] numbers = { 9, 2, 6, 4, 5, 3, 7, 1, 10, 8 };

        // 排序数组
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // 二分查找
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4 in the sorted array: " + index);

        // 对数组的一部分进行排序
        int[] partialArray = { 9, 2, 6, 4, 5 };
        Arrays.sort(partialArray, 1, 4); // 只排序索引 1 到 3（不包括 4）
        System.out.println("Partially sorted array: " + Arrays.toString(partialArray));

        // 并行排序
        Arrays.parallelSort(numbers);
        System.out.println("Array sorted using parallelSort: " + Arrays.toString(numbers));
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
        // 初始化数组
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // 复制整个数组
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));

        // 复制数组的一部分（例如，前5个元素）
        int[] partialCopy = Arrays.copyOfRange(numbers, 0, 5);
        System.out.println("Partial Copy of Array: " + Arrays.toString(partialCopy));
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
        List<Integer> numberList = Arrays.asList(numbers);
        System.out.println("List: " + numberList);

        // 比较两个数组
        Integer[] numbers1 = { 1, 2, 3 };
        Integer[] numbers2 = { 1, 2, 3 };
        boolean areArraysEqual = Arrays.equals(numbers1, numbers2);
        System.out.println("Are arrays equal: " + areArraysEqual);

        // 填充数组
        Arrays.fill(numbers, 20);
        System.out.println("Array after fill: " + Arrays.toString(numbers));
    }

    public static void main(String[] args) {

        ArraysExerciseTest test = new ArraysExerciseTest();
        test.learn_Inserting_And_Retrieving();
        test.learn_search_and_sort();
        test.learn_copy_of_array();
        test.learn_common_operations();

    }
}
