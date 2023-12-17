package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // 创建 LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // 插入元素
        list.add(1); // 相当于 addLast
        list.addFirst(0);
        list.add(2); // 在列表末尾添加
        list.add(1, 10); // 在索引 1 的位置添加

        // 批量添加元素
        list.addAll(Arrays.asList(3, 4, 5));
        list.addAll(0, Arrays.asList(-2, -1)); // 在索引 0 的位置批量添加元素

        // 检索元素
        int firstElement = list.getFirst();
        int lastElement = list.getLast();
        int elementAtIndex1 = list.get(1);

        // 打印结果
        System.out.println("LinkedList: " + list);
        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
        System.out.println("Element at index 1: " + elementAtIndex1);
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        // 创建 LinkedList
        LinkedList<String> list = new LinkedList<>();
        list.add("Day1");
        list.add("Day2");
        list.add("Day3");
        list.add("Day2");

        // 移除元素
        list.removeFirst(); // 移除第一个元素 ("Day1")
        list.removeLast(); // 移除最后一个元素 ("Day2")
        list.remove(0); // 移除索引为 0 的元素 ("Day2")
        list.add("Day2");
        list.add("Day4");
        list.remove("Day4"); // 移除特定元素 ("Day4")

        // 移除最后一次出现的特定元素
        list.removeLastOccurrence("Day2"); // 移除最后一次出现的 "Day2"

        // 打印移除元素后的列表
        System.out.println("List after removals: " + list);

        // 添加元素以用于排序
        list.add("Day1");
        list.add("Day4");

        // 排序列表
        Collections.sort(list);

        // 打印排序后的列表
        System.out.println("Sorted list: " + list);
    }

    public static void main(String[] args) {

        LinkedListExerciseTest test = new LinkedListExerciseTest();
        test.learn_Inserting_And_Retrieving();
        test.learn_Remove_Sort();

    }
}
