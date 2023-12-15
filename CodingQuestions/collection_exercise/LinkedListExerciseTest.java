package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;
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
        list.add(3);
        list.addFirst(1);
        list.add(1,2);
        assertEquals(new LinkedList<>(List.of(1,2,3)), list);

        list.addAll(List.of(4,5,6));
        assertEquals(new LinkedList<>(List.of(1,2,3,4,5,6)), list);

        list.addAll(0,List.of(0,0));
        assertEquals(new LinkedList<>(List.of(0,0,1,2,3,4,5,6)), list);

        assertEquals(list.getFirst(), Integer.valueOf(0));
        assertEquals(list.getLast(), Integer.valueOf(6));
        assertEquals(list.get(2), Integer.valueOf(1));



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
        LinkedList<Character> list = new LinkedList<>(List.of('A','B','C','D'));
        list.removeFirst();
        list.removeLast();

        list.remove(0);
        list.remove(Character.valueOf('C'));
        assertEquals(new LinkedList<>(), list);

        list = new LinkedList<>(List.of('A','B','C','D','C'));
        list.removeLastOccurrence('C');
        assertEquals(new LinkedList<>(List.of('A','B','C','D')), list);

        list.sort(Comparator.reverseOrder());
        assertEquals(new LinkedList<>(List.of('D','C','B','A')), list);


    }
}
