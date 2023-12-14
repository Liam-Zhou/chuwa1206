package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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
        list.add(1,2);
        list.addFirst(7);
        list.addAll(List.of(3,4));
        list.addAll(3,List.of(5,6));
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(3));
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
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6,3));
        list.removeFirst();
        list.remove(2);
        list.removeLastOccurrence(3);
        System.out.println(list);
    }
}
