package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;

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
        // 创建一个 TreeSet 并添加元素
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(5);

        // 一次性添加多个元素
        set.addAll(Arrays.asList(2, 4, 6));

        // 检查是否包含特定元素
        boolean containsFour = set.contains(4);
        System.out.println("集合是否包含数字4: " + containsFour);

        // 获取第一个和最后一个元素
        Integer first = ((TreeSet<Integer>) set).first();
        Integer last = ((TreeSet<Integer>) set).last();
        System.out.println("第一个元素: " + first + ", 最后一个元素: " + last);

        // 获取子集
        Set<Integer> subSet = ((TreeSet<Integer>) set).subSet(2, 5);
        System.out.println("2到5之间的子集: " + subSet);

        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(4);
        System.out.println("小于4的头部集合: " + headSet);

        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(4);
        System.out.println("大于等于4的尾部集合: " + tailSet);

        // 移除元素
        set.remove(2);
        System.out.println("移除数字2后的集合: " + set);

        // 检查集合的大小和是否为空
        int size = set.size();
        boolean isEmpty = set.isEmpty();
        System.out.println("集合的大小: " + size + ", 集合是否为空: " + isEmpty);

    }
}
