package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        // 创建 HashSet 并添加元素
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        // 一次性添加多个元素
        set.addAll(Arrays.asList(4, 5, 6));

        // 检查是否包含特定元素
        boolean containsThree = set.contains(3);
        System.out.println("集合中是否包含数字3: " + containsThree);

        // 移除元素
        set.remove(3);
        System.out.println("移除数字3后的集合: " + set);

        // 检查集合是否为空
        boolean isEmpty = set.isEmpty();
        System.out.println("集合是否为空: " + isEmpty);

        // 清空集合
        set.clear();
        System.out.println("清空后的集合: " + set);
    }
}
