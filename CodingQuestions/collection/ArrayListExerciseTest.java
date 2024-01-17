package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.*;


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
        list.add("A");
        list.add("B");

        assertEquals(2, list.size());
        assertEquals("A", list.get(0));

        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("C");
        anotherList.add("D");
        list.addAll(anotherList);

        assertEquals(4, list.size());
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A","B","C"));
        list.remove(0);
        list.remove("B");
        assertFalse(list.contains("A"));
        assertFalse(list.contains("B"));

        list.set(0,"D");
        assertEquals(0,list.indexOf("D"));

        list.replaceAll(String::toLowerCase);
        assertEquals(0, list.indexOf("d"));
        //assertFalse(list.contains("C"));
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A","B","C","D"));
        Iterator<String> Ir = list.iterator();
        System.out.println("Original list: " + list);

        while (Ir.hasNext()){
            String s = Ir.next();
            if(s.contains("C")){
                Ir.remove();
            }

        }
        System.out.println("After removing C: " + list);

        // 现在可以安全地使用forEachRemaining打印剩余的元素
        Ir = list.iterator(); // 重置迭代器
        Ir.forEachRemaining(System.out::println);

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("D", "B", "A", "C"));

        // Sort using natural order
        Collections.sort(list);
        System.out.println("Sorted in natural order: " + list);

        // Sort using reverse order
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("Sorted in reverse order: " + list);

    }
}
