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
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));

        list2.add(3);
        list2.add(4);
        list.addAll(list2);
        assertTrue(list.containsAll(list2));

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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(Integer.valueOf(2), list.get(0));
        boolean isRemoved = list.remove(Integer.valueOf(2));
        assertTrue(isRemoved);
        assertFalse(list.contains(2));

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer> sublist = list.subList(0,2);
        list.removeAll(sublist);

        assertFalse(list.contains(3));
        assertFalse(list.contains(4));
        assertTrue(list.contains(5));
        assertTrue(list.contains(6));

        list.set(0,1);
        assertEquals(Integer.valueOf(1), list.get(0));
        list.replaceAll(value -> value == 1 ? 6: value);
        assertTrue(list.contains(6));

        assertEquals(Integer.valueOf(6), list.get(0));
        int lastIndex = list.lastIndexOf(6);
//        System.out.println(list);
        assertEquals((long)(1), lastIndex);

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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        list.remove(0);
        assertTrue(!list.contains(1));
//        iterator.forEachRemaining();


    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);

        list.sort(Comparator.naturalOrder());
        assertEquals(Integer.valueOf(1), list.get(0));

        Collections.sort(list, Collections.reverseOrder());
        assertEquals(Integer.valueOf(3), list.get(0));

    }
}
