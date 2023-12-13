package com.chuwa.exercise.collection;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.util.function.UnaryOperator;

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
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        assertEquals(1, arrayList.size());
        assertEquals(Integer.valueOf(1), arrayList.get(0));

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.addAll(arrayList);
        assertEquals(1, arrayList2.size());
        assertEquals(Integer.valueOf(1), arrayList2.get(0));
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

        // remove
        list.remove(1);
        assertArrayEquals(new Integer[]{1}, list.toArray());

        list.add(2);
        list.remove(Integer.valueOf(2));
        assertArrayEquals(new Integer[]{1}, list.toArray());

        list.add(2);
        list.removeAll(List.of(2));
        assertArrayEquals(new Integer[]{1}, list.toArray());

        list.clear();
        assertTrue(list.isEmpty());

        // update
        list.add(1);
        list.add(2);
        list.set(0, 3);
        assertArrayEquals(new Integer[]{3, 2}, list.toArray());
        list.replaceAll(UnaryOperator.identity());

        //check
        assertTrue(list.contains(3));
        assertEquals(0, list.indexOf(3));
        assertEquals(1, list.lastIndexOf(2));
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
        list.add(4);
        list.add(5);
        Iterator<Integer> iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(1), iter.next());
        iter.remove(); // removes 1
        iter.forEachRemaining(System.out::println);
        assertArrayEquals(new Integer[] {2, 3, 4, 5}, list.toArray());
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        Collections.sort(list);
        assertArrayEquals(new Integer[]{1, 2, 3}, list.toArray());
        Collections.sort(list, (a, b) -> b - a);
        assertArrayEquals(new Integer[]{3, 2, 1}, list.toArray());
    }
}
