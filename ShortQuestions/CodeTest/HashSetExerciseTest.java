package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        //创建HashSet
        Set<Integer> set = new HashSet<>();

        // 添加元素
        set.add(1);
        set.add(2);
        set.add(3);

        // 批量添加元素
        set.addAll(Arrays.asList(4, 5, 6));

        // 检查元素是否存在
        boolean containsTwo = set.contains(2);
        System.out.println("Set contains 2: " + containsTwo);

        // 移除元素
        set.remove(3);

        // 检查是否为空
        boolean isEmpty = set.isEmpty();
        System.out.println("Is set empty: " + isEmpty);

        // 清空集合
        set.clear();

        // 再次检查是否为空
        isEmpty = set.isEmpty();
        System.out.println("Is set empty after clear: " + isEmpty);
    }
    public static void main(String[] args) {
        HashSetExerciseTest test = new HashSetExerciseTest();
        test.learn_Inserting_And_Retrieving_Removing();
    }
}
