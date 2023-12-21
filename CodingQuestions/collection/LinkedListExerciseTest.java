package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.*;


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
        LinkedList<Integer> list = new LinkedList<>();

        // 插入元素
        list.add(1); // add(E e)
        list.addFirst(0); // addFirst(E e)
        list.add(2, 2); // add(int index, E element)
        list.addAll(Arrays.asList(3, 4, 5)); // addAll(Collection c)
        list.addAll(3, Arrays.asList(6, 7)); // addAll(int index, Collection c)

        // 检索元素
        System.out.println("第一个元素: " + list.getFirst());
        System.out.println("最后一个元素: " + list.getLast());
        System.out.println("索引2的元素: " + list.get(2));
        System.out.println("完整列表: " + list);

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
        // 创建并初始化 LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);

        // 输出初始列表
        System.out.println("原始列表: " + list);

        // 移除第一个元素
        list.removeFirst();
        System.out.println("移除第一个元素后: " + list);

        // 移除最后一个元素
        list.removeLast();
        System.out.println("移除最后一个元素后: " + list);

        // 移除指定索引的元素
        list.remove(1); // 移除索引为1的元素
        System.out.println("移除索引为1的元素后: " + list);

        // 移除特定对象（第一次出现）
        list.remove(Integer.valueOf(1));
        System.out.println("移除第一次出现的1后: " + list);

        // 再次添加元素以展示 removeLastOccurrence
        list.addLast(4);
        list.addLast(4);

        // 移除最后一次出现的特定对象
        list.removeLastOccurrence(Integer.valueOf(4));
        System.out.println("移除最后一次出现的4后: " + list);

        // 对列表进行排序
        Collections.sort(list);
        System.out.println("排序后的列表: " + list);
    }
}
