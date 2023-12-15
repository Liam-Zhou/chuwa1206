package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.addAll(Arrays.asList(2, 5, 6));
        assertEquals(5, set.size());
        assertTrue(set.contains(2));
        assertFalse(set.contains(7));
        assertEquals(Integer.valueOf(1), set.first());
        assertEquals(Integer.valueOf(6), set.last());
        SortedSet<Integer> subSet = set.subSet(2, 5);
        assertEquals(new TreeSet<>(Arrays.asList(2, 3)), subSet);

        SortedSet<Integer> headSet = set.headSet(4);
        assertEquals(new TreeSet<>(Arrays.asList(1, 2, 3)), headSet);

        SortedSet<Integer> tailSet = set.tailSet(3);
        assertEquals(new TreeSet<>(Arrays.asList(3, 5, 6)), tailSet);
        assertEquals(5, set.size());
        assertFalse(set.isEmpty());


    }
}
