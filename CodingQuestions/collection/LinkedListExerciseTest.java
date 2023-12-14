package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 0);
        list.addAll(List.of(4,5,6));
        list.addAll(0, List.of(-1,-2,-3));
        System.out.println(list);
        list.addFirst(0);
        assertEquals(0, (int)list.getFirst());
        assertEquals(6, (int)list.getLast());
        assertEquals(0, (int)list.get(0));
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
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 0);
        list.addAll(List.of(4,5,6));
        list.addAll(0, List.of(-1,-2,-3));
        list.removeFirst();
        list.removeLast();
        list.remove(0);
        list.remove((Integer) 1);
        list.removeLastOccurrence(2);
        System.out.println(list);
    }
}
