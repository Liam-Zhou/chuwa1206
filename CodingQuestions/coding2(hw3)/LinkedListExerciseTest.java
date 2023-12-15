package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        LinkedList<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        assertEquals(Character.valueOf('b'), list.getLast());
        list.addLast('c');
        assertEquals(Character.valueOf('c'), list.getLast());
        list.addFirst('d');
        assertEquals(Character.valueOf('d'), list.getFirst());

        list.add(3, 'e');
        assertEquals(Character.valueOf('e'), list.get(3));

        List<Character> toAdd = Arrays.asList('a', 'b', 'c');
//        System.out.println(list);
        boolean result = list.addAll(toAdd);
//        System.out.println(list);
        assertTrue(result);
        assertEquals(8, list.size());
        assertEquals(Character.valueOf('a'), list.get(5));
        list.addAll(0, toAdd);
        assertEquals(Character.valueOf('a'), list.get(0));
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
        LinkedList<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.removeFirst();
        assertEquals(Character.valueOf('b'), list.getFirst());
        list.removeLast();
        assertEquals(Character.valueOf('b'), list.getLast());

        list.add('a');
        list.add('b');
        list.add('c');
        list.remove(0);
        assertEquals(Character.valueOf('a'), list.get(0));
        list.remove(Character.valueOf('a'));
        assertEquals(Character.valueOf('b'), list.get(0));
        list.add('a');
        list.add('b');
        list.add('c');
        System.out.println(list);
        list.removeLastOccurrence('c');
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        assertEquals(Character.valueOf('a'), list.get(0));





    }
}
