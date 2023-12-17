package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
        list.add("Element 1");
        list.add(0, "Element 0"); // 在指定索引位置添加元素

        // 批量添加元素
        list.addAll(Arrays.asList("Element 2", "Element 3"));

        // 添加不存在的元素
        list.addIfAbsent("Element 4"); // 如果不存在则添加
        list.addIfAbsent("Element 2"); // 因为已存在，所以不会添加

        // 批量添加不存在的元素
        list.addAllAbsent(Arrays.asList("Element 5", "Element 1")); // 只有 "Element 5" 会被添加

        // 打印列表内容
        System.out.println("List contents: " + list);
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
            String element = itr.next();
            System.out.println("Processing: " + element);

            // 尝试移除元素 - 这将抛出 UnsupportedOperationException
            try {
                itr.remove();
            } catch (UnsupportedOperationException e) {
                System.out.println("Cannot remove items using the iterator of a CopyOnWriteArrayList");
            }
        }
    }
    public static void main(String[] args) {

        CopyOnWriteArrayListExerciseTest test = new CopyOnWriteArrayListExerciseTest();
        test.learn_Inserting_And_Retrieving();
        test.learn_Iterator();

    }
}
