package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

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
        // 创建数组并插入元素
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // 插入元素
        }

        // 检索元素
        int numberAtIndex5 = numbers[5];
        System.out.println("索引5的元素: " + numberAtIndex5);
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
        int[] numbers = { 3, 6, 1, 8, 4, 5 };

        // 排序数组
        Arrays.sort(numbers);
        System.out.println("排序后的数组: " + Arrays.toString(numbers));

        // 二分查找
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("数字4的索引: " + index);

        // 并行排序
        Arrays.parallelSort(numbers);
        System.out.println("并行排序后的数组: " + Arrays.toString(numbers));
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

        // 复制整个数组
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("复制的数组: " + Arrays.toString(copiedArray));

        // 复制数组的一部分
        int[] rangeCopy = Arrays.copyOfRange(numbers, 0, 5);
        System.out.println("复制的数组范围: " + Arrays.toString(rangeCopy));
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

        // 转换为列表
        List<Integer> numberList = Arrays.asList(numbers);
        System.out.println("转换为列表: " + numberList);

        // 检查两个数组是否相等
        Integer[] anotherArray = { 1, 2, 3, 4, 5 };
        boolean areEqual = Arrays.equals(numbers, anotherArray);
        System.out.println("两个数组是否相等: " + areEqual);

        // 填充数组
        Arrays.fill(numbers, 20);
        System.out.println("填充后的数组: " + Arrays.toString(numbers));
    }
}
