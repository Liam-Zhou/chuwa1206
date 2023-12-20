package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

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
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.addAll(set);
        assertTrue(set2.contains(1));

        set2.add(2);
        set2.add(0);

        assertEquals(0, set2.first());
        assertEquals(2, set2.last());

        assertArrayEquals(new Integer[]{0, 1}, set2.subSet(0, 2).toArray());
        assertArrayEquals(new Integer[]{0, 1}, set2.headSet( 2).toArray());
        assertArrayEquals(new Integer[]{1, 2}, set2.tailSet( 1).toArray());

        set2.remove(1);
        set.clear();
        assertTrue(set.isEmpty());
    }
}
