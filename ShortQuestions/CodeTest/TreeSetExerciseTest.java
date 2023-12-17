package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        // 创建 TreeSet
        TreeSet<Integer> set = new TreeSet<>();

        // 添加元素
        set.add(10);
        set.add(20);
        set.add(30);

        // 批量添加元素
        set.addAll(java.util.Arrays.asList(40, 50, 60));

        // 检查元素是否存在
        boolean contains20 = set.contains(20);

        // 获取第一个和最后一个元素
        int first = set.first();
        int last = set.last();

        // 获取子集
        Set<Integer> subSet = set.subSet(20, 50);
        Set<Integer> headSet = set.headSet(30);
        Set<Integer> tailSet = set.tailSet(30);

        // 移除元素
        set.remove(60);

        // 获取大小和检查是否为空
        int size = set.size();
        boolean isEmpty = set.isEmpty();

        // 打印结果
        System.out.println("TreeSet: " + set);
        System.out.println("Contains 20: " + contains20);
        System.out.println("First element: " + first);
        System.out.println("Last element: " + last);
        System.out.println("SubSet (20, 50): " + subSet);
        System.out.println("HeadSet (30): " + headSet);
        System.out.println("TailSet (30): " + tailSet);
        System.out.println("Size: " + size);
        System.out.println("Is empty: " + isEmpty);
    }

    public static void main(String[] args) {
        TreeSetExerciseTest test = new TreeSetExerciseTest();
        test.learn_Inserting_And_Retrieving_Removing();
    }
}
