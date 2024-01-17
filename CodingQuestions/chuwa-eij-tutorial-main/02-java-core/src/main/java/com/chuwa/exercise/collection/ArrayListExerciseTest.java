package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // 测试大小
        assertEquals(3, list.size());

        // 测试获取元素
        assertEquals("Apple", list.get(0));
        assertEquals("Banana", list.get(1));

        // 测试addAll
        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("Date");
        anotherList.add("Elderberry");
        list.addAll(anotherList);

        assertEquals(5, list.size());
        assertTrue(list.containsAll(anotherList));
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));

        // 测试移除
        list.remove(0); // 移除"Apple"
        assertFalse(list.contains("Apple"));

        // 测试set
        list.set(0, "Blueberry"); // 将"Banana"替换为"Blueberry"
        assertEquals("Blueberry", list.get(0));

        // 测试replaceAll
        list.replaceAll(String::toUpperCase);
        assertEquals("BLUEBERRY", list.get(0));

        // 测试contains和indexOf
        assertTrue(list.contains("CHERRY"));
        assertEquals(2, list.indexOf("CHERRY"));

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        Iterator<String> it = list.iterator();

        // 测试迭代器
        int count = 0;
        while (it.hasNext()) {
            count++;
            it.next();
        }
        assertEquals(list.size(), count);

        // 测试forEachRemaining (Java 8)
        it = list.iterator(); // 重置迭代器
        List<String> tempList = new ArrayList<>();
        it.forEachRemaining(tempList::add);

        assertEquals(list, tempList);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Cherry", "Banana", "Apple"));
        Collections.sort(list);
        assertEquals(Arrays.asList("Apple", "Banana", "Cherry"), list);

        // 测试反向排序
        list.sort(Comparator.reverseOrder());
        assertEquals(Arrays.asList("Cherry", "Banana", "Apple"), list);
    }
}