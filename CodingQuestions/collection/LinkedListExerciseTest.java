package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;

import static org.junit.Assert.*;
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
        list.addFirst(0);
        list.add(2);

        assertEquals(Integer.valueOf(0), list.getFirst());
        assertEquals(Integer.valueOf(2), list.getLast());
        assertEquals(Integer.valueOf(1), list.get(1));
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
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0,1,2,2,3,4));


        list.removeFirst();
        assertEquals(1, (int) list.getFirst());
        list.removeLast();
        assertEquals(3,(int)list.getLast());
        list.remove(Integer.valueOf(2));



        Collections.sort(list);
        assertEquals(Arrays.asList(1, 2, 3), list);
    }
}
