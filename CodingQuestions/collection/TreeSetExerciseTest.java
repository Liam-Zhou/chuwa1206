package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.TreeSet;
import java.util.Set;
import java.util.Arrays;

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


        set.add(3);
        set.add(1);
        set.addAll(Arrays.asList(4, 2, 5));

        assertTrue(set.contains(3));


        assertEquals(Integer.valueOf(1), set.first());
        assertEquals(Integer.valueOf(5), set.last());

        assertEquals(new TreeSet<>(Arrays.asList(2, 3, 4)), set.subSet(2, 5));
        assertEquals(new TreeSet<>(Arrays.asList(1, 2)), set.headSet(3));
        assertEquals(new TreeSet<>(Arrays.asList(3, 4, 5)), set.tailSet(3));


        set.remove(3);
        assertFalse(set.contains(3));

        assertEquals(4, set.size());
        assertFalse(set.isEmpty());
    }
}
