package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Arrays;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // 添加元素
        list.add("A");
        list.add(1, "B"); // 在指定索引处添加
        list.addAll(Arrays.asList("C", "D", "E"));
        list.addIfAbsent("F"); // 如果不存在，则添加
        list.addAllAbsent(Arrays.asList("G", "H")); // 添加所有不存在的元素

        // 检索元素
        System.out.println("完整列表: " + list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // CopyOnWriteArrayList 的迭代器不支持 remove() 操作
        // 执行 itr.remove(); 将会抛出 UnsupportedOperationException
    }
}
