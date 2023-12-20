package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addLast(2);
        list.addFirst(3);
        assertArrayEquals(new Integer[]{3, 1, 2}, list.toArray());
        list.add(1, 4);
        assertArrayEquals(new Integer[]{3, 4, 1, 2}, list.toArray());
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addAll(list);
        list2.addAll(0,list);
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeFirst();
        assertArrayEquals(new Integer[]{2, 3}, list.toArray());
        list.removeLast();
        assertArrayEquals(new Integer[]{2}, list.toArray());
        list.remove(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2));
        list.removeLastOccurrence(3);
    }
}
