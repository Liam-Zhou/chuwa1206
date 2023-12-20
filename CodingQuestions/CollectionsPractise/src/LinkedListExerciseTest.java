//package com.chuwa.exercise.collection;

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
        list.addLast(3);
        list.addFirst(0);
        list.add(2, 4);
        list.addAll(new LinkedList<Integer>() {{
            add(5);
            add(6);
        }});
        list.addAll(2, new LinkedList<Integer>() {{
            add(7);
            add(8);
        }});
        assertEquals(0, list.getFirst().intValue());
        assertEquals(6, list.getLast().intValue());
        assertEquals(7, list.get(2).intValue());
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
        list.addLast(3);
        list.addFirst(0);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.removeFirst();
        list.removeLast();
        list.remove(0);
        list.remove(new Integer(2));
        list.removeLastOccurrence(4);
        list.sort((a, b) -> a - b);
        System.out.println(list);
    }
}
